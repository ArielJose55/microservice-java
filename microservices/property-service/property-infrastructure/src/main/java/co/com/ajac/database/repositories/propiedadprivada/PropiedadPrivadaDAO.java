package co.com.ajac.database.repositories.propiedadprivada;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import io.vavr.collection.List;
import io.vavr.control.Option;

@RegisterRowMapper(PropiedadPrivadaMapper.class)
public interface PropiedadPrivadaDAO {

	@SqlUpdate("INSERT INTO \"PROPIEDAD_PRIVADA\"("
			+ "	ubicacion"
			+ ")"
			+ "	VALUES"
			+ "("
			+ "	:pc.ubicacion"
			+ ")")
	boolean guardarPropiedadPrivada(@BindBean("pc") PropiedadPrivadaRecord propiedadPrivadaRecord);
	
	@SqlQuery("SELECT * FROM \"PROPIEDAD_PRIVADA\" pp"
			+ "	WHERE"
			+ "	pp.id = :id"
			+ "")
	Option<PropiedadPrivadaRecord> obtenerPropiedadPrivadaPorSuId(@Bind("id") Integer id);
	
	@SqlQuery("SELECT * FROM \"PROPIEDAD_PRIVADA\" pp"
			+ "	WHERE"
			+ "	pp.nit_propiedad_horizontal = :nit"
			+ "")
	List<PropiedadPrivadaRecord> obtenerPropiedadesPrivadaPorSuPropiedadHorizontal(@Bind("nit") String nit);
	
}
