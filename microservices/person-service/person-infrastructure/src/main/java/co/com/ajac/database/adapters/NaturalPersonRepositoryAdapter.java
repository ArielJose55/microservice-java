package co.com.ajac.database.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.database.repositories.NaturalPersonJdbiRespository;
import co.com.ajac.ports.NaturalPersonRepository;

@Component
public class NaturalPersonRepositoryAdapter implements NaturalPersonRepository {

	@Autowired
	private NaturalPersonJdbiRespository repository;
	
	@Override
	public Boolean verifyExistence(String identification) {
		return repository.verifyExistence(identification);
	}	
}
