package co.com.ajac.database.repositories.reserva;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class ReservaMapper implements RowMapper<ReservaRecord>{

	@Override
	public ReservaRecord map(ResultSet rs, StatementContext ctx) throws SQLException {
		return new ReservaRecord(
				rs.getInt("id_reserva"),
				rs.getString("descripcion"),
				rs.getString("estado_reserva"),
				rs.getTimestamp("fecha_inicio"),
				rs.getTimestamp("fecha_finalizacion"),
				rs.getInt("bien_comun"),
				rs.getString("numero_identificacion"),
				rs.getString("tipo_identificacion")
				);
	}

}
