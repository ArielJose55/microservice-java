package co.com.ajac.database.repositories.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import co.com.ajac.database.repositories.personanatural.PersonaNaturalRecord;

public class UsuarioMapper implements RowMapper<UsuarioRecord>{

	@Override
	public UsuarioRecord map(ResultSet rs, StatementContext ctx) throws SQLException {
		
		PersonaNaturalRecord personaNaturalRecord = new PersonaNaturalRecord(
				rs.getString("numero_identificacion"),
				rs.getString("tipo_identificacion"),
				rs.getString("primer_nombre"),
				rs.getString("segundo_nombre"),
				rs.getString("primer_apellido"),
				rs.getString("segundo_apellido"));
		
		return new UsuarioRecord(
				personaNaturalRecord,
				rs.getString("username"),
				rs.getString("password"),
				rs.getString("tipo_usuario"),
				rs.getString("estado_usuario"),
				rs.getTimestamp("fecha_registro"),
				rs.getTimestamp("fecha_finalizacion"));
	}
	
	

}
