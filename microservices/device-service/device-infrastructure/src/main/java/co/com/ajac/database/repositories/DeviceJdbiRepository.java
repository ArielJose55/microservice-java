package co.com.ajac.database.repositories;

import org.checkerframework.checker.units.qual.h;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.models.Device;

@Repository
public class DeviceJdbiRepository {

	
	private final Jdbi jdbi;

	@Autowired
	public DeviceJdbiRepository(Jdbi jdbi) {
		this.jdbi = jdbi;
	}
	
	public boolean save(Device device) {
		try(Handle handle = jdbi.open()){
			int updatedRows = handle.createUpdate("")
					.bindBean(device)
					.execute();
			
			return updatedRows > 0;
		}
	}
}
