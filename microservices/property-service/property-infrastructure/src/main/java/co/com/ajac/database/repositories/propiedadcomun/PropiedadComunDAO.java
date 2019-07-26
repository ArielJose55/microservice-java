package co.com.ajac.database.repositories.propiedadcomun;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import io.vavr.collection.List;
import io.vavr.control.Option;

@RegisterRowMapper(PropiedadComunMappper.class)
public interface PropiedadComunDAO {

	@SqlUpdate("INSERT INTO \"PROPIEDAD_COMUN\"("
			+ "	nombre,"
			+ "	esencial,"
			+ "	nit_propiedad_horizontal"
			+ ")"
			+ "	VALUES"
			+ "("
			+ "	:pc.nombre,"
			+ "	:pc.esencial,"
			+ "	:pc.propiedadHorizontalRecord.nit"
			+ ")")
	boolean guardarPropiedadComun(@BindBean("pc") PropiedadComunRecord propiedadComunRecord);
	
	@SqlQuery("SELECT * FROM \"PROPIEDAD_COMUN\" pc"
			+ "	WHERE"
			+ "	pc.id = :id"
			)
	Option<PropiedadComunRecord> obtenerPropiedadComunPorSuId(@Bind("id") Integer id);
	
	@SqlQuery("SELECT * FROM \"PROPIEDAD_COMUN\" com"
			+ "	JOIN \"PROPIEDAD_HORIZONTAL\" hor"
			+ "	ON com.nit_propiedad_horizontal = hor.nit"
			+ "	JOIN \"GESTION_PROPIEDAD_HORIZONTAL\" gph"
			+ "	ON hor.nit = gph.nit_propiedad_horizontal"
			+ "	WHERE"
			+ "	com.nit_propiedad_horizontal =:nit"
			)
	List<PropiedadComunRecord> obtenerPropiedadesComunesPorSuPropiedadHorizontal(@Bind("nit") String nit);
}
