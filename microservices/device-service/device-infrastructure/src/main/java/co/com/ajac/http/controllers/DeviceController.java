package co.com.ajac.http.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.models.Device;
import co.com.ajac.usecases.device.FindAllDevice;
import co.com.ajac.usecases.device.FindDevice;
import co.com.ajac.usecases.device.RegisterDevice;

@RestController
@RequestMapping
public class DeviceController {

	private final RegisterDevice registerDevice;
	private final FindDevice findDevice;
	private final FindAllDevice findAllDevice;
	
	@Autowired
	public DeviceController(RegisterDevice registerDevice, FindDevice findDevice, FindAllDevice findAllDevice) {
		this.registerDevice = registerDevice;
		this.findDevice = findDevice;
		this.findAllDevice = findAllDevice;
	}

	@PostMapping
	public Device addDevice(@Valid @RequestBody Device device) {
		return registerDevice.execute(device);
	}
	
	@GetMapping("/{serial}")
	public Device findDeviceBySerial(@PathVariable("serial") String serial) {
		return findDevice.execute(serial);
	}
	
	@GetMapping("/bien/{bien}")
	public List<Device> findAllDevice(@PathVariable("bien") Integer bienComun) {
		return findAllDevice.execute(bienComun);
	}
}
