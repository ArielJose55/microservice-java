package co.com.ajac.services;

import co.com.ajac.models.Device;
import co.com.ajac.ports.IDeviceRepository;

public class DeviceService {

	private final IDeviceRepository deviceRepository;

	public DeviceService(IDeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}
	
	public boolean addDevice(Device device) {
		return deviceRepository.addDevice(device);
	}
	
	
	
}
