package co.com.ajac.ports;

import java.util.List;
import java.util.Optional;

import co.com.ajac.models.Device;
import io.vavr.control.Option;

public interface DeviceRepository {
	
	public Option<Integer> regsterDevice(Device device);
	
	public Optional<Device> getDevice(String serial);
	
	public Optional<List<Device>> listDevicesByProperty(Integer property);
	
}
