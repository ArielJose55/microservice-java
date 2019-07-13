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

import co.com.ajac.commands.RegisterDevice;
import co.com.ajac.models.Device;
import co.com.ajac.queries.DeviceQueryResource;


@RestController
@RequestMapping
public class DeviceController {

	private final RegisterDevice registerDevice;
	private final DeviceQueryResource deviceQueryResource;
	
	@Autowired
	public DeviceController(RegisterDevice registerDevice, DeviceQueryResource deviceQueryResource) {
		this.registerDevice = registerDevice;
		this.deviceQueryResource = deviceQueryResource;
	}

	@PostMapping
	public void addDevice(@Valid @RequestBody Device device) {
		registerDevice.execute(device);	
	}
	
	@GetMapping("/{serial}")
	public Device findDeviceBySerial(@PathVariable("serial") String serial) {
		return deviceQueryResource.findOneDevice(serial);
	}
	
	@GetMapping("/commons/{bien}")
	public List<Device> findAllDevice(@PathVariable("bien") Integer bienComun) {
		return deviceQueryResource.listDevicesByProperty(bienComun).asJava();
	}
}
