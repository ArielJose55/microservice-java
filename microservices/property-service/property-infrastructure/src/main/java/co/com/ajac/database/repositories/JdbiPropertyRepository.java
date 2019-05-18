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
public class JdbiPropertyRepository {

	@Autowired
	private Jdbi jdbi;
	
	public Option<Integer> register(HorizontalProperty horizontalProperty){
		
		@Cleanup
		Handle handle = jdbi.open();
		
		final Function0<Integer> registerOne = () -> handle.createUpdate("")
				.bindBean(horizontalProperty)
				.executeAndReturnGeneratedKeys("")
				.mapTo(Integer.class)
				.findOnly();
		return Function0.lift(registerOne).apply();
	}
	
	public Option<HorizontalProperty> findOne(Integer id){
		@Cleanup
		final Handle handle = jdbi.open();
		
		final Function0<HorizontalProperty> findOne = () -> handle.createQuery("")
			.bind("id",id)
			.mapTo(HorizontalProperty.class)
			.findOnly();
		
		return Function0.lift(findOne).apply();
	}
	
	
}
