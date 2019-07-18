package co.com.ajac.database.repositories.propiedadhorizontal.propiedadhorizontal;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import co.com.ajac.database.repositories.propiedadhorizontal.administrador.AdministradorRecord;
import io.vavr.collection.List;

public class PropiedadHorizontalMapper implements RowMapper<PropiedadHorizontalRecord> {

	@Override
	public PropiedadHorizontalRecord map(ResultSet rs, StatementContext ctx) throws SQLException {

		AdministradorRecord administrador = new AdministradorRecord(
				rs.getString("nit_propiedad_horizontal"),
				rs.getString("numero_identificacion"),
				rs.getString("tipo_identificacion"),
				rs.getTimestamp("fecha_asignacion"));
		
		return new PropiedadHorizontalRecord(
				rs.getString("nit"),
				rs.getString("nombre_distintivo"),
				administrador,
				List.empty(),
				List.empty());
	}

}
