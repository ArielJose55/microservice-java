package co.com.ajac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ajac.ports.ResidentRepository;
import co.com.ajac.ports.UserRepository;
import co.com.ajac.ports.LegalPersonRepository;
import co.com.ajac.ports.NaturalPersonRepository;
import co.com.ajac.ports.PropertyCommunicator;
import co.com.ajac.ports.ReservationRepository;
import co.com.ajac.services.legalperson.LegalPersonService;
import co.com.ajac.services.naturalperson.NaturalPersonService;
import co.com.ajac.services.reserve.ReservationService;
import co.com.ajac.services.resident.ResidentService;
import co.com.ajac.services.user.UserService;

@Configuration
public class BeanService {

	@Bean
	public UserService beanUserService(UserRepository userRepository) {
		return new UserService(userRepository);
	}
	
	@Bean
	public ResidentService deanResidentService(ResidentRepository residentRepository) {
		return new ResidentService(residentRepository);
	}
	
	@Bean
	public LegalPersonService serviceLegalPerson(LegalPersonRepository legalPersonRepository) {
		return new LegalPersonService(legalPersonRepository);
	}
	
	@Bean
	public ReservationService beanReservationService(NaturalPersonRepository naturalPersonRepository, PropertyCommunicator propertyCommunicator, ReservationRepository reservationRepository) {
		return new ReservationService(naturalPersonRepository, propertyCommunicator, reservationRepository);
	}
	
	@Bean
	public NaturalPersonService beanNaturalPersonService(NaturalPersonRepository naturalPersonRepository) {
		return new NaturalPersonService(naturalPersonRepository);
	}
}
