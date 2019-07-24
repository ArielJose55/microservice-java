package co.com.ajac.database.repositories.personajuridica;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import io.vavr.control.Option;

@RegisterRowMapper(PersonaJuridicaMapper.class)
public interface PersonaJuridicaDAO {

	@SqlUpdate("INSERT INTO \"PERSONA_JURIDICA\"("
			+ "	nit,"
			+ "	razon_social,"
			+ "	objeto_social"
			+ "	)VALUES ("
			+ "	:pj.nit,"
			+ "	:pj.razonSocial,"
			+ "	:pj.objetoSocial"
			+ ")")
	boolean registrarPersonaJuridica(@BindBean("pj") PersonaJuridicaRecord personaJuridicaRecord);
	
	@SqlQuery("SELECT * FROM \"PERSONA_JURIDICA\" pj"
			+ "	WHERE pj.nit =:nit")
	Option<PersonaJuridicaRecord> obtenerPersonaJuridica(@Bind("nit") String nit);
}
