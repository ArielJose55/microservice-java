package co.com.ajac.database.repositories.personanatural;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class PersonaNaturalMapper implements RowMapper<PersonaNaturalRecord>{

	@Override
	public PersonaNaturalRecord map(ResultSet rs, StatementContext ctx) throws SQLException {
		return new PersonaNaturalRecord(
				rs.getString("numero_identificacion"),
				rs.getString("tipo_identificacion"),
				rs.getString("primer_nombre"),
				rs.getString("segundo_nombre"),
				rs.getString("primer_apellido"),
				rs.getString("segundo_apellido"));
	}
}
