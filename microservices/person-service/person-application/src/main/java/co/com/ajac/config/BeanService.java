package co.com.ajac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ajac.ports.IResidentRepository;
import co.com.ajac.ports.IUserRepository;
import co.com.ajac.services.resident.ResidentService;
import co.com.ajac.services.user.UserService;

@Configuration
public class BeanService {

	@Bean
	public UserService serviceUser(IUserRepository userRepository) {
		return new UserService(userRepository);
	}
	
	@Bean
	public ResidentService serviceResident(IResidentRepository residentRepository) {
		return new ResidentService(residentRepository);
	}
}
