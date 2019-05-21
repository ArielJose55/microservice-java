package co.com.ajac.database.repositories;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.domain.HorizontalProperty;
import io.vavr.Function0;
import io.vavr.control.Option;
import lombok.Cleanup;

@Repository
public class PropertyJdbiRepository {

	private static final String INSERT_HORIZONTAL_PROPERTY = "INSERT INTO \"HORIZONTAL_PROPERTY\" (distinctive_name, legal_person_fk) VALUES (:distinctiveName, :identification)";
	private static final String SELECT_ONE_HORIZONTAL_PROPERTY = "SELECT legal_person_fk FROM \"HORIZONTAL_PROPERTY\" ho WHERE ho.legal_person_fk =:id";
	
	@Autowired
	private Jdbi jdbi;
	
	public Option<String> register(HorizontalProperty horizontalProperty){
		
		@Cleanup
		Handle handle = jdbi.open();
		
		final Function0<String> registerOne = () -> handle.createUpdate(INSERT_HORIZONTAL_PROPERTY)
				.bindBean(horizontalProperty)
				.executeAndReturnGeneratedKeys("legal_person_fk")
				.mapTo(String.class)
				.findOnly();
	
		return Function0.lift(registerOne).apply();
	}
	
	public Option<String> findOne(String id){
		@Cleanup
		final Handle handle = jdbi.open();
		
		final Function0<String> findOne = () -> handle.createQuery(SELECT_ONE_HORIZONTAL_PROPERTY)
			.bind("id",id)
			.mapTo(String.class)
			.findOnly();
		
		return Function0.lift(findOne).apply();
	}
	
	
}
