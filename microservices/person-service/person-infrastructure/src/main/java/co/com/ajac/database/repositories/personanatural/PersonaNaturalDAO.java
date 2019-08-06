package co.com.ajac.database.repositories.personanatural;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

@RegisterRowMapper(PersonaNaturalMapper.class)
public interface PersonaNaturalDAO {

	@SqlUpdate("INSERT INTO \"PERSONA_NATURAL\"("
			+ "	numero_identificacion,"
			+ "	tipo_identificacion,"
			+ "	primer_nombre,"
			+ "	segundo_nombre,"
			+ "	primer_apellido,"
			+ "	segundo_apellido)"
			+ "	VALUES ("
			+ "	:persona.numeroIdentificacion,"
			+ "	:persona.tipoIdentificacion,"
			+ "	:persona.primerNombre,"
			+ "	:persona.segundoNombre,"
			+ "	:persona.primerApellido,"
			+ "	:persona.segundoApellido"
			+ ")")
	boolean registrarPersonaNatural(@BindBean("persona") PersonaNaturalRecord personaNaturalRecord);
}
