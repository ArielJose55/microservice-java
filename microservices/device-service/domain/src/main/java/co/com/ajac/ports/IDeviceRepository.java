package co.com.ajac.ports;

import java.util.List;
import java.util.Optional;

import co.com.ajac.models.Device;

public interface IDeviceRepository {

	public boolean verifyFingerprint(String fingerPrint);
	
	public boolean verifySecurityCode(String securityCode);
	
	public boolean addDevice(Device device);
	
	public Optional<Device> getDevice(String serial);
	
	public Optional<List<Device>> getDevicesByProperty(String property);
}
