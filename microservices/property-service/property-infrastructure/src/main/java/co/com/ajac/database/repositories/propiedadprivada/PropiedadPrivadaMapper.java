package co.com.ajac.database.repositories.propiedadprivada;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class PropiedadPrivadaMapper implements RowMapper<PropiedadPrivadaRecord>{

	@Override
	public PropiedadPrivadaRecord map(ResultSet rs, StatementContext ctx) throws SQLException {
		return new PropiedadPrivadaRecord(
				rs.getInt("id"),
				rs.getString("ubicacion")
				);				
	}

}
