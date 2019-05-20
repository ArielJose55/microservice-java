package co.com.ajac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ajac.ports.PersonCommunicator;
import co.com.ajac.ports.PropertyRespository;
import co.com.ajac.services.horizontal.HorizontalService;

@Configuration
public class BeansService {

	@Bean
	public HorizontalService beanHorizontalService(PropertyRespository propertyRespository, PersonCommunicator personCommunicator) {
		return new HorizontalService(propertyRespository, personCommunicator);
	}
}
