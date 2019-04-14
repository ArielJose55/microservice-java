package co.com.ajac.database.repositories;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.models.Device;
import lombok.Cleanup;

@Repository
public class DeviceJdbiRepository {

	
	private static final String INSERT_DEVICE = "INSERT INTO \"DISPOSITIVO\"( name, serial, bien_comun ) VALUES ( :nombre, :serial, :biencomun)";
	private static final String SELECT_DEVICE_BY_SERIAL = "SELECT id, name, serial, bien_comun, state FROM \"DISPOSITIVO\" d WHERE d.serial = :serial";
	
	private final Jdbi jdbi;

	@Autowired
	public DeviceJdbiRepository(Jdbi jdbi) {
		this.jdbi = jdbi;
	}
	
	public Optional<Device> save(Device device) {
		
		@Cleanup
		Handle handle = jdbi.open();
		return handle.createUpdate(INSERT_DEVICE)
				.bind("nombre", device.getName())
				.bind("serial", device.getSerial())
				.bind("biencomun", device.getBienComun())
				.executeAndReturnGeneratedKeys()
				.mapToBean(Device.class)
				.findFirst();
	}
	
	public Optional<Device> getDevice(String serial){
		
		@Cleanup
		Handle handle = jdbi.open();
		return handle.createQuery(SELECT_DEVICE_BY_SERIAL)
			.bind("serial", serial)
			.mapToBean(Device.class)
			.findFirst();
	}
	
	public Optional<List<Device>> getAllDeviceByBienComun(String bienComun){
		
		@Cleanup
		Handle handle = jdbi.open();
		return Optional.ofNullable(
				handle.createQuery("")
				.bind("biencommun", bienComun)
				.mapToBean(Device.class)
				.list());
	}
}
