package co.com.ajac.database.repositories;

import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CommonPropertyJdbiRepository {

	@Autowired
	public CommonPropertyJdbiRepository(Jdbi jdbi) {
		
	}

	
}
