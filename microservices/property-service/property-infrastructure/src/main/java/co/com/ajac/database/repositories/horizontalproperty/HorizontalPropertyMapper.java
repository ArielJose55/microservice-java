package co.com.ajac.database.repositories.horizontalproperty;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import io.vavr.collection.List;

public class HorizontalPropertyMapper implements RowMapper<HorizontalPropertyRecord>{

	@Override
	public HorizontalPropertyRecord map(ResultSet rs, StatementContext ctx) throws SQLException {
		
		return new HorizontalPropertyRecord(
				rs.getInt(""),
				rs.getString("distinctive_name"),
				rs.getString(""),
				List.empty(),
				List.empty());
	}
	
	

}
