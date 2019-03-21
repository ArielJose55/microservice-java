package co.com.ajac.database.repositories;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HistoricalJdbiRepository {

	private final Jdbi jdbi;

	@Autowired
	public HistoricalJdbiRepository(Jdbi jdbi) {
		this.jdbi = jdbi;
	}
	
	public boolean registerAccess(String serial, String identification) {
		try (Handle handle = jdbi.open()){
			int updateRows = handle.createUpdate("")
					.bind("serial", serial)
					.bind("identification", identification)
					.execute();
			
			return updateRows > 0;
		}
	}
}
