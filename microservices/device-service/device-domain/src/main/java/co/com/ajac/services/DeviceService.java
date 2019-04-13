package co.com.ajac.services;

import java.util.List;
import java.util.Optional;

import co.com.ajac.exceptions.NotFountModelException;
import co.com.ajac.models.Device;
import co.com.ajac.ports.DeviceRepository;

public class DeviceService {

	private final DeviceRepository deviceRepository;

	public DeviceService(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}
	
	public boolean addDevice(Device device) {
		return deviceRepository.addDevice(device);
	}
	
	public Optional<List<Device>> listDevicesByProperty(Integer property) {
		return deviceRepository.listDevicesByProperty(property);
	}
	
	public Optional<Device> findDevice(String securityCode) {
		return deviceRepository.getDevice(securityCode);
				//.orElseThrow(() -> new NotFountModelException("No nay ningun registro de algun dispositivo con este serial"));
	}
}
