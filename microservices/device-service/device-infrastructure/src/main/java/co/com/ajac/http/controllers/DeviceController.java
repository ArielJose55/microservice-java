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

import domain.exceptions.NotSaveModelException;
import co.com.ajac.models.Device;
import co.com.ajac.rabbitmq.adapters.NotifierRabbitmq;
import co.com.ajac.usecases.device.FindAllDevice;
import co.com.ajac.usecases.device.FindDevice;
import co.com.ajac.usecases.device.RegisterDevice;
import io.vavr.control.Option;

@RestController
@RequestMapping
public class DeviceController {

	private final RegisterDevice registerDevice;
	private final FindDevice findDevice;
	private final FindAllDevice findAllDevice;
	private final NotifierRabbitmq notifier;
	
	@Autowired
	public DeviceController(RegisterDevice registerDevice, FindDevice findDevice, FindAllDevice findAllDevice, NotifierRabbitmq notifier) {
		this.registerDevice = registerDevice;
		this.findDevice = findDevice;
		this.findAllDevice = findAllDevice;
		this.notifier = notifier;
	}

	@PostMapping
	public Integer addDevice(@Valid @RequestBody Device device) {
		Option<Integer> result = registerDevice.execute(device);	
		return result.getOrElseThrow(() -> new NotSaveModelException("Ooops! El dispositivo no fue registrado. Intetenlo nuevamente"));
	}
	
	@GetMapping("/{serial}")
	public Device findDeviceBySerial(@PathVariable("serial") String serial) {
		return findDevice.execute(serial);
	}
	
	@GetMapping("/bien/{bien}")
	public List<Device> findAllDevice(@PathVariable("bien") Integer bienComun) {
		return findAllDevice.execute(bienComun);
	}
	
	@PostMapping("/mq")
	public void sendMessage(@RequestBody String message) {
		notifier.sendResult(message);
	}
}
