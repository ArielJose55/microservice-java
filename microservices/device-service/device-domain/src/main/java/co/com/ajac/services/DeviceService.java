package co.com.ajac.services;

import static io.vavr.API.*;
import static io.vavr.Patterns.$None;
import static io.vavr.Patterns.$Some;

import java.util.Optional;

import co.com.ajac.models.Device;
import co.com.ajac.ports.DeviceRepository;
import co.com.ajac.ports.PropertyCommunicator;
import io.vavr.Function0;
import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Either;
import io.vavr.control.Option;

public class DeviceService {

	private static final String ALIAS_COMMON_PROPERTY = "COMMON_PROPERTY";
	
	private final DeviceRepository deviceRepository;
	private final PropertyCommunicator propertyRepository;
	
	public DeviceService(DeviceRepository deviceRepository, PropertyCommunicator propertyRepository) {
		this.deviceRepository = deviceRepository;
		this.propertyRepository = propertyRepository;
	}

	public Either<Seq<String>, Option<Integer>> registerDevice(final Device device) {
		
		final Function0<Integer> checkProperty = () -> 
			propertyRepository.checkExistenceProperty(device.getBienComun(), ALIAS_COMMON_PROPERTY).get();
		
		final Option<Integer> isCommonProperty = Function0.lift(checkProperty).apply();

		return Match(isCommonProperty).of(
				Case($Some($()), idCommonProperty -> Either.right(deviceRepository.regsterDevice(device))),
				Case($None(), Either.left(List.of("Este Bien Comun no se encuentra registrado en el sistema")))
		);
	}

	public Optional<java.util.List<Device>> listDevicesByProperty(Integer property) {
		return deviceRepository.listDevicesByProperty(property);
	}

	public Optional<Device> findDevice(String securityCode) {
		return deviceRepository.getDevice(securityCode);
	}
	
}
