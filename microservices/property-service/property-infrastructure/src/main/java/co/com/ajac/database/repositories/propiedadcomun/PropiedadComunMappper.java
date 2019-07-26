package co.com.ajac.database.repositories.propiedadcomun;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import co.com.ajac.database.repositories.propiedadhorizontal.administrador.AdministradorRecord;
import co.com.ajac.database.repositories.propiedadhorizontal.propiedadhorizontal.PropiedadHorizontalRecord;
import io.vavr.collection.List;

public class PropiedadComunMappper implements RowMapper<PropiedadComunRecord>{

	@Override
	public PropiedadComunRecord map(ResultSet rs, StatementContext ctx) throws SQLException {
		
		AdministradorRecord administrador = new AdministradorRecord(
				rs.getString("nit_propiedad_horizontal"),
				rs.getString("numero_identificacion"),
				rs.getString("tipo_identificacion"),
				rs.getTimestamp("fecha_asignacion"));
		
		PropiedadHorizontalRecord propiedadHorizontalRecord = new PropiedadHorizontalRecord(
				rs.getString("nit"),
				rs.getString("nombre_distintivo"),
				administrador,
				List.empty(),
				List.empty());
		
		return new PropiedadComunRecord(
				rs.getInt("id"),
				rs.getString("nombre"),
				rs.getBoolean("esencial"),
				propiedadHorizontalRecord
				);
	}
}
