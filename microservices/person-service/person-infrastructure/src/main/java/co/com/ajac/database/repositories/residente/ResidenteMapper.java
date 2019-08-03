package co.com.ajac.database.repositories.residente;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import co.com.ajac.database.repositories.personanatural.PersonaNaturalRecord;

public class ResidenteMapper implements RowMapper<ResidenteRecord>{

	@Override
	public ResidenteRecord map(ResultSet rs, StatementContext ctx) throws SQLException {
		
		PersonaNaturalRecord personaNaturalRecord = new PersonaNaturalRecord(
				rs.getString("numero_identificacion"),
				rs.getString("tipo_identificacion"),
				rs.getString("primer_nombre"),
				rs.getString("segundo_nombre"),
				rs.getString("primer_apellido"),
				rs.getString("segundo_apellido"));
		
		return new ResidenteRecord(
				personaNaturalRecord,
				rs.getString("plantilla_huella"),
				rs.getString("codigo_seguridad"),
				rs.getBoolean("titular")
				);
	}

}
