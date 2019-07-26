package co.com.ajac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ajac.repositories.PropiedadComunRepository;
import co.com.ajac.repositories.PropiedadHorizontalRepository;
import co.com.ajac.repositories.PropiedadPrivadaRepository;
import co.com.ajac.services.PropiedadComunService;
import co.com.ajac.services.PropiedadHorizontalService;

@Configuration
public class BeansService {

	@Bean
	public PropiedadHorizontalService beanHorizontalService(
			PropiedadHorizontalRepository propiedadHorizontalRepository,
			PropiedadComunRepository propiedadComunRepository,
			PropiedadPrivadaRepository propiedadPrivadaRepository) {
		return new PropiedadHorizontalService(propiedadHorizontalRepository, propiedadComunRepository, propiedadPrivadaRepository);
	}
	
	@Bean
	public PropiedadComunService beanPropiedadComunService(PropiedadComunRepository propiedadComunRepository) {
		return new PropiedadComunService(propiedadComunRepository);
	}
}
