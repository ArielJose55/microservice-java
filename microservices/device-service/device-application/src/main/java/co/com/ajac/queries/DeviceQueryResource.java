package co.com.ajac.queries;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ajac.models.Device;
import co.com.ajac.services.DeviceService;
import domain.exceptions.ModelNotFoundException;
import io.vavr.collection.List;

public class DeviceQueryResource {

	
	private final DeviceService deviceService;
	
	@Autowired
	public DeviceQueryResource(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	
	public List<Device> listDevicesByProperty(Integer commonProperty) {
		return deviceService.listDevicesByProperty(commonProperty);
	}
	
	
	public Device findOneDevice(String serial) {
		return deviceService.findDevice(serial)
				.getOrElseThrow(() -> new ModelNotFoundException("Dispositivo no registrado"));
	}
}
