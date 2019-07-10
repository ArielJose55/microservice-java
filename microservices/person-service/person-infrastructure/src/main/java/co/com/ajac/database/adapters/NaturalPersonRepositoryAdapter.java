package co.com.ajac.database.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.database.repositories.NaturalPersonJdbiRespository;
import co.com.ajac.ports.NaturalPersonRepository;
import coremodel.NaturalPerson;

@Component
public class NaturalPersonRepositoryAdapter implements NaturalPersonRepository {
	
	private final NaturalPersonJdbiRespository repository;
	
	@Autowired
	public NaturalPersonRepositoryAdapter(NaturalPersonJdbiRespository repository) {
		this.repository = repository;
	}

	@Override
	public Boolean verifyExistence(String identification) {
		return repository.verifyExistence(identification);
	}

	@Override
	public NaturalPerson findOne(String identification) {
		return repository.findOneNaturalPerson(identification);
	}	
}
