package co.com.ajac.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.models.Device;
import co.com.ajac.services.DeviceService;
import common.Command;
import domain.exceptions.NotSaveModelException;
import io.vavr.control.Either;
import io.vavr.control.Option;

@Component
public class RegisterDevice implements Command<Device>{

	private final DeviceService deviceService;
	
	@Autowired
	public RegisterDevice(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	@Override
	public void execute(Device device) {
		Either<String, Option<String>> eitherResult = deviceService.registerDevice(device);
		
		eitherResult.getOrElseThrow(
				() -> new NotSaveModelException(eitherResult.getLeft()))
				.getOrElseThrow(() -> new NotSaveModelException("Ooops! El dispositivo no fue registrado. Intetenlo nuevamente"));
	}
}
