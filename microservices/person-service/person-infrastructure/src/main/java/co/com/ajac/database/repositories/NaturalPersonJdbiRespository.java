package co.com.ajac.database.repositories;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.vavr.Function0;
import lombok.Cleanup;

@Repository
public class NaturalPersonJdbiRespository {

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
				.findOnly();
		
		return Function0.lift(verify).apply().getOrElse(Boolean.FALSE);
	}
}
