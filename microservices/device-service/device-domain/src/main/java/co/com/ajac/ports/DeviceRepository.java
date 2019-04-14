package co.com.ajac.ports;

import java.util.List;
import java.util.Optional;

import co.com.ajac.models.Device;

public interface DeviceRepository {
	
	public Optional<Device> addDevice(Device device);
	
	public Optional<Device> getDevice(String serial);
	
	public Optional<List<Device>> listDevicesByProperty(Integer property);
	
}
