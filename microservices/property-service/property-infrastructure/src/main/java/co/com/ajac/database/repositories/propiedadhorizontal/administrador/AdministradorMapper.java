package co.com.ajac.database.repositories.propiedadhorizontal.administrador;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class AdministradorMapper implements RowMapper<AdministradorRecord>{

	@Override
	public AdministradorRecord map(ResultSet rs, StatementContext ctx) throws SQLException {
		
		return new AdministradorRecord(
				rs.getString("nit_propiedad_horizontal"),
				rs.getString("numero_identificacion"),
				rs.getString("tipo_identificacion"),
				rs.getTimestamp("fecha_asignacion"));
	}

	
}
