package co.com.ajac.database.repositories;

import java.util.stream.Collectors;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.domain.CommonProperty;
import io.vavr.Function0;
import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.Cleanup;

@Repository
public class CommonJdbiRepository {

	private static final String SELECT_ALL_COMMON_BY_NIT = "SELECT co.id, co.name, co.essential, co.nit_horizantal_property FROM \"COMMON_PROPERTY\" co" + 
			"\tJOIN \"HORIZONTAL_PROPERTY\" ho ON co.nit_horizantal_property = ho.legal_person_fk" + 
			"\tWHERE co.nit_horizantal_property =:horinzontalProperty";
	
	private static final String INSERT_COMMON_PROPERTY ="INSERT INTO \"COMMON_PROPERTY\"(name, essential, nit_horizantal_property)" + 
				"\tVALUES (:name, :essential, :nitHorizantalProperty)";
	
	@Autowired
	private Jdbi jdbi;
	
	public List<CommonProperty> findAllCommonPropertyBy(String identification){
		
		@Cleanup
		final Handle handle = jdbi.open();
		
		final Function0<List<CommonProperty>> findAll = () -> List.ofAll(handle.createQuery(SELECT_ALL_COMMON_BY_NIT)
				.bind("horinzontalProperty", identification)
				.mapToBean(CommonProperty.class)
				.collect(Collectors.toList()));
		
		return Function0.lift(findAll).apply().getOrElse(List.empty());
	}
	
	public Option<Integer> registerCommonProperty(CommonProperty property){
		
		@Cleanup
		final Handle handle = jdbi.open();
		
		final Function0<Integer> register = () -> handle.createUpdate(INSERT_COMMON_PROPERTY)
				.bindBean(property)
				.executeAndReturnGeneratedKeys("id")
				.mapTo(Integer.class)
				.findOnly();
		
		return Function0.lift(register).apply();
	}
}
