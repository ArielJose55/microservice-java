package co.com.ajac.database.repositories.personanatural;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

@RegisterRowMapper(PersonaNaturalMapper.class)
public interface PersonaNaturalDAO {

	@SqlUpdate("INSERT INTO \"PERSONA_NATURAL\"("
			+ "	numero_identificacion,"
			+ "	primer_apellido,"
			+ "	primer_nombre,"
			+ "	segundo_nombre,"
			+ "	tipo_identificacion,"
			+ "	segundo_apellido)"
			+ "	VALUES ("
			+ "	:persona.numeroIdentificacion,"
			+ "	:persona.primerNombre,"
			+ "	:persona.segundoNombre,"
			+ "	:persona.primerApellido,"
			+ "	:persona.tipoIdentificacion,"
			+ "	:persona.segundoApellido"
			+ ")")
	boolean registrarPersonaNatural(@BindBean("persona") PersonaNaturalRecord personaNaturalRecord);
}
