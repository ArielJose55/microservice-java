package co.com.ajac.database.repositories.usuario;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import io.vavr.control.Option;

@RegisterRowMapper(UsuarioMapper.class)
public interface UsuarioDAO {

	@SqlUpdate("INSERT INTO \"USUARIO\"("
			+ "	username,"
			+ "	password,"
			+ "	tipo_usuario,"
			+ "	estado_usuario,"
			+ "	fecha_finalizacion,"
			+ "	tipo_identificacion,"
			+ "	numero_identificacion)"
			+ "	VALUES ("
			+ "	:usuario.username,"
			+ "	:usuario.password,"
			+ "	:usuario.tipoUsuario,"
			+ "	:usuario.estadoUsuario,"
			+ "	:usuario.fechaFinalizacion,"
			+ "	:usuario.personaNaturalRecord.tipoIdentificacion,"
			+ "	:usuario.personaNaturalRecord.numeroIdentificacion"
			+ ")")
	boolean registrarUsuario(@BindBean("usuario") UsuarioRecord usuarioRecord);
	
	@SqlQuery("SELECT * FROM \"USUARIO\" usu"
			+ "	JOIN \"PERSONA_NATURAL\" per"
			+ "	ON usu.numero_identificacion = per.numero_identificacion"
			+ "	AND usu.tipo_identificacion = per.tipo_identificacion"
			+ "	WHERE usu.username =:username")
	Option<UsuarioRecord> obtenerUsuarioPorUsername(@Bind("username") String username);
	
	@SqlQuery("SELECT * FROM \"USUARIO\" usu"
			+ "	JOIN \"PERSONA_NATURAL\" per"
			+ "	ON usu.numero_identificacion = per.numero_identificacion"
			+ "	AND usu.tipo_identificacion = per.tipo_identificacion"
			+ "	WHERE usu.numero_identificacion =:numId"
			+ "	AND usu.tipo_identificacion = :tipoId"
			+ "")
	Option<UsuarioRecord> obtenerUsuarioPorSuIdentificacion(@Bind("tipoId") String tipoId, @Bind("numId") String numId);
}
