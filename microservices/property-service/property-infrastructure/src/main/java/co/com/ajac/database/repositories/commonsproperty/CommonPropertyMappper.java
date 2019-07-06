package co.com.ajac.database.repositories.commonsproperty;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class CommonPropertyMappper implements RowMapper<CommonPropertyRecord>{

	@Override
	public CommonPropertyRecord map(ResultSet rs, StatementContext ctx) throws SQLException {
		return new CommonPropertyRecord(rs.getInt(""), rs.getString(""), rs.getBoolean(""));
	}
}
