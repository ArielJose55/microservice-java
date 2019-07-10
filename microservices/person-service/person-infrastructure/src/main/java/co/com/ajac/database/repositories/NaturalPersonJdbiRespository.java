package co.com.ajac.database.repositories;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import coremodel.NaturalPerson;
import domain.exceptions.ModelNotFoundException;
import io.vavr.Function0;
import lombok.Cleanup;

@Repository
public class NaturalPersonJdbiRespository {

	private static final String FIND_ONE_NATURAL_PERSON = "SELECT * FROM \"NATURAL_PERSON\" na" + 
			"	JOIN \"PERSON\" pe ON na.person_fk = pe.identification" + 
			"	WHERE na.person_fk =: identification;";

	private static final String VERIFY_IF_EXISTS = "SELECT EXISTS (SELECT * FROM \"NATURAL_PERSON\" na" + 
				"\tJOIN \"PERSON\" pe ON na.person_fk = pe.identification" + 
				"\tWHERE na.person_fk = :identification)";
	
	@Autowired
	private Jdbi jdbi;
	
	public Boolean verifyExistence(String identification) {
		
		@Cleanup
		final Handle handle = jdbi.open();
		
		final Function0<Boolean> verify = () -> handle.createQuery(VERIFY_IF_EXISTS)
				.bind("identification", identification)
				.mapTo(Boolean.class)
				.first();
		
		return Function0.lift(verify).apply().getOrElse(Boolean.FALSE);
	}
	
	public NaturalPerson findOneNaturalPerson(String identification) {
		
		@Cleanup
		final Handle handle = jdbi.open();
		
		final Function0<NaturalPerson> findOne = () ->
			handle.createQuery(FIND_ONE_NATURAL_PERSON)
			.bind("identification", identification)
			.map((rs, ctx) -> new NaturalPerson(
					rs.getString("person_fk"),
					rs.getString("typeIdentification"),
					rs.getString("name"),
					rs.getString("last_name")))
			.first();
			
		return Function0.lift(findOne).apply()
				.getOrElseThrow(() -> new ModelNotFoundException("No se encontro ninguna persona natural con esta identificacion"));
		
	}
}
