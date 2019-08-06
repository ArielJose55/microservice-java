package co.com.ajac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ajac.ports.PersonaJuridicaRepository;
import co.com.ajac.ports.ReservaRepository;
import co.com.ajac.ports.ResidenteRepository;
import co.com.ajac.ports.UsuarioRepository;
import co.com.ajac.services.PersonaJuridicaService;
import co.com.ajac.services.ReservaService;
import co.com.ajac.services.ResidenteService;
import co.com.ajac.services.UsuarioService;

@Configuration
public class BeanService {

	@Bean
	public UsuarioService beanUserService(UsuarioRepository userRepository, ResidenteRepository residenteRepository) {
		return new UsuarioService(userRepository, residenteRepository);
	}
	
	@Bean
	public PersonaJuridicaService beanPersonaJuridicaService(PersonaJuridicaRepository personaJuridicaRepository) {
		return new PersonaJuridicaService(personaJuridicaRepository);
	}
	
	@Bean
	public ResidenteService beanResidenteService(ResidenteRepository residenteRepository) {
		return new ResidenteService(residenteRepository);
	}
	
	@Bean
	public ReservaService serviceLegalPerson(ReservaRepository reservaRepository) {
		return new ReservaService(reservaRepository);
	}
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
