package co.com.ajac.ports;


import co.com.ajac.models.Device;
import io.vavr.collection.List;
import io.vavr.control.Option;

public interface DeviceRepository {
	
	public Option<String> regsterDevice(Device device);
	
	public Option<Device> getDevice(String serial);
	
	public List<Device> listDevicesByProperty(Integer bienComun);
	
}
