package co.com.ajac.database.repositories;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.models.Device;
import io.vavr.Function0;
import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.Cleanup;

@Repository
public class DeviceJdbiRepository {

	
	private static final String INSERT_DEVICE = "INSERT INTO \"DISPOSITIVO\"( name, serial, bien_comun ) VALUES ( :nombre, :serialNumber, :bienComun)";
	private static final String SELECT_DEVICE_BY_SERIAL = "SELECT id, name, serial, bien_comun, state FROM \"DISPOSITIVO\" d WHERE d.serial = :serial";
	private static final String FIND_ALL_DEVICE_BY_COMMON = "SELECT id, name, serial, bien_comun, state FROM \"DISPOSITIVO\" WHERE bien_comun = :biencommun";
	
	private final Jdbi jdbi;

	@Autowired
	public DeviceJdbiRepository(Jdbi jdbi) {
		this.jdbi = jdbi;
	}
	
	public Option<String> save(Device device) {

		@Cleanup
		final Handle handle = jdbi.open();

		final Function0<String> functionSave = () -> handle.createUpdate(INSERT_DEVICE)
				.bind("nombre", device.getName())
				.bind("serialNumber", device.getSerial())
				.bind("bienComun", device.getBienComun())
				.executeAndReturnGeneratedKeys("serial")
				.mapTo(String.class)
				.findOnly();
		
		return Function0.lift(functionSave).apply();
	}
	
	public Option<Device> getDevice(String serial){
		
		@Cleanup
		final Handle handle = jdbi.open();
		
		final Function0<Device> findOne = () -> handle.createQuery(SELECT_DEVICE_BY_SERIAL)
			.bind("serial", serial)
			.mapToBean(Device.class)
			.findOnly();
		
		return Function0.lift(findOne).apply();
	}
	
	public List<Device> getAllDeviceByBienComun(Integer bienComun){
		
		@Cleanup
		final Handle handle = jdbi.open();
		
		final Function0<List<Device>> findAll = () -> List.ofAll(handle.createQuery(FIND_ALL_DEVICE_BY_COMMON)
				.bind("biencommun", bienComun)
				.mapToBean(Device.class)
				.list());
		
		return Function0.lift(findAll).apply().getOrElse(List.empty());
	}
}
