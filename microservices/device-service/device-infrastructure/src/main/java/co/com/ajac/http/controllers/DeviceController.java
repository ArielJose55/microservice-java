package co.com.ajac.http.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.models.Device;
import co.com.ajac.usecases.device.RegisterDevice;

@RestController
@RequestMapping("/device")
public class DeviceController {

	private final RegisterDevice registerDevice;
	
	@Autowired
	public DeviceController(RegisterDevice registerDevice) {
		this.registerDevice = registerDevice;
	}

	@PostMapping
	public boolean addDevice(@Valid @RequestBody Device device) {
		return registerDevice.execute(device);
	}
}
