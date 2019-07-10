package co.com.ajac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ajac.ports.acls.PersonCommunicator;
import co.com.ajac.ports.repositories.CommonPropertyRepository;
import co.com.ajac.ports.repositories.HorizontalPropertyRespository;
import co.com.ajac.services.common.CommonService;
import co.com.ajac.services.horizontal.HorizontalService;

@Configuration
public class BeansService {

	@Bean
	public HorizontalService beanHorizontalService(HorizontalPropertyRespository propertyRespository, PersonCommunicator personCommunicator) {
		return new HorizontalService(propertyRespository, personCommunicator);
	}
	
	@Bean
	public CommonService beanCommonService(CommonPropertyRepository commonPropertyRepository, HorizontalPropertyRespository propertyRespository) {
		return new CommonService(commonPropertyRepository, propertyRespository);
	}
}
