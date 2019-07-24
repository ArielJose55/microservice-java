package co.com.ajac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ajac.ports.PersonaJuridicaRepository;
import co.com.ajac.ports.UsuarioRepository;
import co.com.ajac.services.PersonaJuridicaService;
import co.com.ajac.services.UsuarioService;

@Configuration
public class BeanService {

	@Bean
	public UsuarioService beanUserService(UsuarioRepository userRepository) {
		return new UsuarioService(userRepository);
	}
	
	@Bean
	public PersonaJuridicaService beanPersonaJuridicaService(PersonaJuridicaRepository personaJuridicaRepository) {
		return new PersonaJuridicaService(personaJuridicaRepository);
	}
//	
//	@Bean
//	public AdministradorService serviceLegalPerson(AdministradorRepository legalPersonRepository) {
//		return new AdministradorService(legalPersonRepository);
//	}
//	
//	@Bean
//	public ReservationService beanReservationService(NaturalPersonRepository naturalPersonRepository, PropertyCommunicator propertyCommunicator, ReservationRepository reservationRepository) {
//		return new ReservationService(naturalPersonRepository, propertyCommunicator, reservationRepository);
//	}
//	
//	@Bean
//	public NaturalPersonService beanNaturalPersonService(NaturalPersonRepository naturalPersonRepository) {
//		return new NaturalPersonService(naturalPersonRepository);
//	}
}
