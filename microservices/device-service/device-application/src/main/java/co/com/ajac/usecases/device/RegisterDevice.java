package co.com.ajac.usecases.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.exceptions.NotSaveModelException;
import co.com.ajac.models.Device;
import co.com.ajac.services.DeviceService;
import common.Query;
import io.vavr.control.Either;
import io.vavr.control.Option;

@Component
public class RegisterDevice implements Query<String, Device>{

	private final DeviceService deviceService;
	
	@Autowired
	public RegisterDevice(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	@Override
	public String execute(Device device) {
		Either<String, Option<String>> eitherResult = deviceService.registerDevice(device);
		
		return eitherResult.getOrElseThrow(
				() -> new NotSaveModelException(eitherResult.getLeft()))
				.getOrElseThrow(() -> new NotSaveModelException("Ooops! El dispositivo no fue registrado. Intetenlo nuevamente"));
	}
}
