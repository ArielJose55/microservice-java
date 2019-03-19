package co.com.ajac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import co.com.ajac.ports.DeviceRepository;
import co.com.ajac.ports.HistorialRepository;
import co.com.ajac.services.DeviceService;
import co.com.ajac.services.HistoricalService;

@Component
public class BeanService {

	
	@Bean
	public DeviceService beanDeviceService( DeviceRepository deviceRepository ) {
		return new DeviceService(deviceRepository);
	}
	
	@Bean
	public HistoricalService beanDeviceService( HistorialRepository historialRepository ) {
		return new HistoricalService(historialRepository);
	}
}
