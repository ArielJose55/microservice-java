package co.com.ajac.database.repositories;

import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.models.Device;

@Repository
public class DeviceJdbiRepository {

	
	private static final String INSERT_DEVICE = "INSERT INTO \"DISPOSITIVO\"( name, serial, bien_comun ) VALUES ( :nombre, :serial, :biencomun)";
	private static final String SELECT_DEVICE_BY_SERIAL = "SELECT id, name, serial, bien_comun, state FROM \"DISPOSITIVO\" d WHERE d.serial = :serial";
	
	private final Jdbi jdbi;

	@Autowired
	public DeviceJdbiRepository(Jdbi jdbi) {
		this.jdbi = jdbi;
	}
	
	public boolean save(Device device) {
		try(Handle handle = jdbi.open()){
			Integer updatedRows = handle.createUpdate(INSERT_DEVICE)
					.bind( "nombre", device.getName() )
					.bind( "serial", device.getSerial() )
					.bind( "biencomun", device.getBienComun())
					.execute();
			
			return updatedRows > 0;
		}
	}
	
	public Optional<Device> getDevice(String serial){
		return jdbi.withHandle( handle  -> 
			handle.createQuery(SELECT_DEVICE_BY_SERIAL)
			.bind("serial", serial)
			.mapToBean(Device.class)
			.findFirst());
	}
	
}
