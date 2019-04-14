package co.com.ajac.usecases.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.exceptions.NotSaveModelException;
import co.com.ajac.models.Device;
import co.com.ajac.services.DeviceService;
import common.usecases.Query;

@Component
public class RegisterDevice implements Query<Device, Device>{

	private final DeviceService deviceService;
	
	@Autowired
	public RegisterDevice(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	@Override
	public Device execute(Device device) {
		return deviceService.addDevice(device)
				.orElseThrow(() -> new NotSaveModelException("¡Oups! No fue posible almacenar el dispositivo. Intentelo nuevamente"));
	}
}
