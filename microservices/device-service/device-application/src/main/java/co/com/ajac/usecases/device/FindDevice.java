package co.com.ajac.usecases.device;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.models.Device;
import co.com.ajac.services.DeviceService;
import common.usecases.Query;

@Component
public class FindDevice implements Query<Device, String>{

	private final DeviceService deviceService;
	
	@Autowired
	public FindDevice(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	@Override
	public Device execute(String serial) {
		return deviceService.findDevice(serial);
	}

}
