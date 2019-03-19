package co.com.ajac.usecases.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.models.Device;
import co.com.ajac.services.DeviceService;
import common.usecases.Command;

@Component
public class RegisterDevice implements Command<Device>{

	private final DeviceService deviceService;
	
	@Autowired
	public RegisterDevice(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	@Override
	public boolean execute(Device device) {
		return deviceService.addDevice(device);
	}
}
