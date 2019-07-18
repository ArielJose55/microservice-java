package co.com.ajac.database.repositories.propiedadhorizontal.propiedadhorizontal;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import co.com.ajac.domain.phs.Administrador;
import io.vavr.collection.List;
import io.vavr.control.Option;

@RegisterRowMapper(PropiedadHorizontalMapper.class)
public interface PropiedadHorizontalDAO {
	
	@SqlUpdate("INSERT INTO \"PROPIEDAD_HORIZONTAL\"(" + 
			"	nit," +
			"	nombre_distintivo)" + 
			"	VALUES (" +
			"	:ph.nit, " +
			"	:ph.nombreDistintivo" +
			")")
	boolean registrarPropiedadHorizontal(@BindBean("ph") PropiedadHorizontalRecord ph);
	
	@SqlQuery("SELECT * FROM \"PROPIEDAD_HORIZONTAL\" ph" + 
			"	JOIN \"GESTION_PROPIEDAD_HORIZONTAL\" ge" + 
			"	ON ph.nit = ge.nit_propiedad_horizontal" + 
			"	WHERE ge.tipo_identificacion = :admin.tipoIdentificacion" +
			" 	AND" + 
			"	ge.numero_identificacion = :admin.numeroIdentificacion")
	List<PropiedadHorizontalRecord> obtenerTodasPropiedadesHorizontalesPorAdministrador(@BindBean("admin") Administrador admin);

	
	@SqlQuery("SELECT * FROM \"PROPIEDAD_HORIZONTAL\" ph" +
			"	JOIN \"GESTION_PROPIEDAD_HORIZONTAL\" ge" +
			"	ON ph.nit = ge.nit_propiedad_horizontal"  +
			" 	WHERE"+
			" 	ph.nit = :nit")
	Option<PropiedadHorizontalRecord> obtenerPropiedadHorizontalPorNit(@Bind("nit") String nit);
}
