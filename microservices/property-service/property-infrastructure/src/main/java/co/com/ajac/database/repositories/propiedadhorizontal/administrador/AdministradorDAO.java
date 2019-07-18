package co.com.ajac.database.repositories.propiedadhorizontal.administrador;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

@RegisterRowMapper(AdministradorMapper.class)
public interface AdministradorDAO {
	
	@SqlUpdate("INSERT INTO \"GESTION_PROPIEDAD_HORIZONTAL\"(" + 
			"	numero_identificacion," + 
			"	tipo_identificacion," + 
			"	nit_propiedad_horizontal)" + 
			"	VALUES ("+
			" 	:administrador.numeroId," +
			"	:administrador.tipoId, " +
			"	:administrador.nit)")
	boolean registrarAdministradorDeUnaPropiedadHorizontal(@BindBean("administrador") AdministradorRecord administrador);

}
