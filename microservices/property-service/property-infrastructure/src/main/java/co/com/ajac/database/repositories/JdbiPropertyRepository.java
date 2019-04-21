package co.com.ajac.database.repositories;

import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.domain.HorizontalProperty;
import lombok.Cleanup;

@Repository
public class JdbiPropertyRepository {

	@Autowired
	private Jdbi jdbi;
	
	public Optional<HorizontalProperty> register(HorizontalProperty horizontalProperty){
		
		@Cleanup
		Handle handle = jdbi.open();
		
		return handle.createUpdate("")
				.bindBean(horizontalProperty)
				.executeAndReturnGeneratedKeys()
				.mapTo(HorizontalProperty.class)
				.findFirst();
	}
	
	public Optional<HorizontalProperty> getOne(Integer id, boolean withAttributes){
		@Cleanup
		Handle handle = jdbi.open();
		
		return handle.createQuery("")
		.bind("id",id)
		.mapTo(HorizontalProperty.class)
		.findFirst();
	}
}
