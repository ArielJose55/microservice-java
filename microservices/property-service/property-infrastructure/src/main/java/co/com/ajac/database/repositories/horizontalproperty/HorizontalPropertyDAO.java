package co.com.ajac.database.repositories.horizontalproperty;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import io.vavr.collection.List;
import io.vavr.control.Option;

@RegisterRowMapper(HorizontalPropertyMapper.class)
public interface HorizontalPropertyDAO {
	
	@SqlQuery("SELECT id, distinctive_name, nit_identification" + 
			"	FROM HORIZONTAL_PROPERTY ho "+ 
			"	WHERE ho.nit_identification = : identification")
	List<HorizontalPropertyRecord> listAllHorizontalPropertyByAdmin(@Bind("identification") String identification);

}
