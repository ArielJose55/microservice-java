package co.com.ajac.services;

import static io.vavr.API.*;
import static io.vavr.Patterns.$None;
import static io.vavr.Patterns.$Some;

import co.com.ajac.models.Device;
import co.com.ajac.ports.DeviceRepository;
import co.com.ajac.ports.PropertyCommunicator;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;

public class DeviceService {

	private static final String ALIAS_COMMON_PROPERTY = "COMMON_PROPERTY";
	
	private final DeviceRepository deviceRepository;
	private final PropertyCommunicator propertyCommunicator;
	
	public DeviceService(DeviceRepository deviceRepository, PropertyCommunicator propertyRepository) {
		this.deviceRepository = deviceRepository;
		this.propertyCommunicator = propertyRepository;
	}

	/**
	 * 
	 * @param device
	 * @return
	 */
	public Either<String, Option<String>> registerDevice(final Device device) {
		
		Option<Integer> isCommonProperty = propertyCommunicator.checkExistenceProperty(device.getBienComun(), ALIAS_COMMON_PROPERTY);

		Option<List<Device>> orElse = isCommonProperty.map(deviceRepository::listDevicesByProperty)
				.orElse(Option.none());

		return Match(orElse).of(
				Case($Some($()), list -> {
					
					Option<Device> existenceOne = list.find(de -> de.getSerial().equals(device.getSerial()) || de.getName().equals(device.getName()));
					list.peek(de -> System.out.println(de + "\t" + device));
					list.peek(de -> System.out.println( de.getSerial().equals(device.getSerial()) + "\t" + de.getName().equals(device.getName())));
					System.out.println(existenceOne);
					
					return Match(existenceOne).of(
							Case($Some($()), one -> Either.left("Ouup! Ya existe un dispositivo para este bien comun con este serial mismo serial o nombre")),
							Case($None(), none -> Either.right(deviceRepository.regsterDevice(device)))
							);					                                                                                                
				}),
				Case($None(), Either.left("Oups! no tenemos registro de ningun bien comun registrado con este id: " +device.getBienComun()))
				);
	}

	/**
	 * 
	 * @param property
	 * @return
	 */
	public List<Device> listDevicesByProperty(Integer property) {
		return deviceRepository.listDevicesByProperty(property);
	}

	/**
	 * 
	 * @param securityCode
	 * @return
	 */
	public Option<Device> findDevice(String securityCode) {
		return deviceRepository.getDevice(securityCode);
	}
	
}
