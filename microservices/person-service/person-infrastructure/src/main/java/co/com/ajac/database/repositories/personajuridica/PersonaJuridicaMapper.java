package co.com.ajac.database.repositories.personajuridica;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class PersonaJuridicaMapper implements RowMapper<PersonaJuridicaRecord>{

	@Override
	public PersonaJuridicaRecord map(ResultSet rs, StatementContext ctx) throws SQLException {
		return new PersonaJuridicaRecord(
				rs.getString("nit"),
				rs.getString("razon_social"),
				rs.getString("objeto_social"));
	}

}
