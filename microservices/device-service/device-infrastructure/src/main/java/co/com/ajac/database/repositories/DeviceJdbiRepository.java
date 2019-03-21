package co.com.ajac.database.repositories;

import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.models.Device;

@Repository
public class DeviceJdbiRepository {

	
	private static final String INSERT_DEVICE = "INSERT INTO \"DISPOSITIVO\"( nombre, security_code, bien_comun_id, estado) VALUES ( :nombre, :serial, :biencomun, :estado)";
	private static final String SELECT_DEVICE_BY_SERIAL = "SELECT nombre, security_code, bien_comun_id, estado FROM \"DISPOSITIVO\" d WHERE d.security_code = :serial";
	
	private final Jdbi jdbi;

	@Autowired
	public DeviceJdbiRepository(Jdbi jdbi) {
		this.jdbi = jdbi;
	}
	
	public boolean save(Device device) {
		try(Handle handle = jdbi.open()){
			int updatedRows = handle.createUpdate(INSERT_DEVICE)
					.bind( "name", device.getName() )
					.bind( "serial", device.getSecurityCode() )
					.bind( "biencomun", device.getBienComun() )
					.bind( "estado", device.getState() )
					.execute();
			
			return updatedRows > 0;
		}
	}
	
	public Optional<Device> getDevice(String serial){
		try(Handle handle = jdbi.open()){
			Device devide = handle.createQuery(SELECT_DEVICE_BY_SERIAL)
					.bind("serial", serial)
					.mapToBean(Device.class)
					.findOnly();
			
			return Optional.ofNullable(devide);
		}
		
	}
	
	
}
