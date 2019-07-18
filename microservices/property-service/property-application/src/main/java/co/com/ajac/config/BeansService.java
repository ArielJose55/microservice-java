package co.com.ajac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ajac.repositories.PropiedadHorizontalRepository;
import co.com.ajac.services.horizontal.PropiedadHorizontalService;

@Configuration
public class BeansService {

	@Bean
	public PropiedadHorizontalService beanHorizontalService(PropiedadHorizontalRepository propiedadHorizontalRepository ) {
		return new PropiedadHorizontalService(propiedadHorizontalRepository);
	}
	
//	@Bean
//	public CommonService beanCommonService(CommonPropertyRepository commonPropertyRepository, HorizontalPropertyRespository propertyRespository) {
//		return new CommonService(commonPropertyRepository, propertyRespository);
//	}
}
