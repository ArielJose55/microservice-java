package co.com.ajac.database.repositories;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.models.LegalDataPerson;
import io.vavr.Function0;
import io.vavr.control.Option;
import lombok.Cleanup;

@Repository
public class LegalPersonJdbiRepository {

	private static final String INSERT_PERSON = "INSERT INTO \"PERSON\"(identification, \"typeIdentification\") VALUES (:identification, :typeIdentification)";
	private static final String INSERT_LEGAL_PERSON = "INSERT INTO \"LEGAL_PERSON\"(business_name, social_objetive, person_pk) VALUES (:businessName, :socialObjetive, :identification)";
	private static final String FIND_ONE_LEGAL_PERSON = "SELECT * FROM \"LEGAL_PERSON\" le JOIN \"PERSON\" pe ON le.person_pk = pe.identification WHERE le.person_pk =:identification";
	private final Jdbi jdbi;
	
	@Autowired
	public LegalPersonJdbiRepository(Jdbi jdbi) {
		this.jdbi = jdbi;
	}
	
	public Option<Integer> saveLegalPerson(LegalDataPerson legalDataPerson){
		
		@Cleanup
		final Handle handle = jdbi.open();
		
		final Function0<Integer>  save =  () ->  handle.inTransaction(h -> {
			h.createUpdate(INSERT_PERSON)
				.bind("identification", legalDataPerson.getIdentification())
				.bind("typeIdentification", legalDataPerson.getTypeIdentification())
				.execute();
	
			return h.createUpdate(INSERT_LEGAL_PERSON)
					.bind("businessName", legalDataPerson.getBusinessName())
					.bind("socialObjetive", legalDataPerson.getSocialObjective())
					.bind("identification", legalDataPerson.getIdentification())
					.executeAndReturnGeneratedKeys()
					.mapTo(Integer.class)
					.findOnly();	
		});
				
		
		return Function0.lift(save).apply();
	}
	
	public Option<LegalDataPerson> findByIdentification(String identification){
		
		@Cleanup
		final Handle handle = jdbi.open();
		
		final Function0<LegalDataPerson> find = () -> handle.createQuery(FIND_ONE_LEGAL_PERSON)
				.bind("identification", identification)
				.mapToBean(LegalDataPerson.class)
				.findOnly();
		
		return Function0.lift(find).apply();
	}
}
