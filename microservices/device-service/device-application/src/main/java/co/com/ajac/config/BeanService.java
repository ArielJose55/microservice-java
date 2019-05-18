package co.com.ajac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ajac.ports.DeviceRepository;
import co.com.ajac.ports.HistorialRepository;
import co.com.ajac.ports.PropertyCommunicator;
import co.com.ajac.services.DeviceService;
import co.com.ajac.services.HistoricalService;

@Configuration
public class BeanService {
	
	@Bean
	public DeviceService beanDeviceService( DeviceRepository deviceRepository , PropertyCommunicator propertyRepository) {
		return new DeviceService(deviceRepository, propertyRepository);
	}
	
	@Bean
	public HistoricalService beanHistoricalService( HistorialRepository historialRepository ) {
		return new HistoricalService(historialRepository);
	}
}
