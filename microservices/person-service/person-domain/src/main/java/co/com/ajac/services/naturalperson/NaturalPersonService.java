package co.com.ajac.services.naturalperson;

import co.com.ajac.ports.NaturalPersonRepository;
import coremodel.NaturalPerson;

public class NaturalPersonService {

	private final NaturalPersonRepository repository;

	public NaturalPersonService(NaturalPersonRepository repository) {
		this.repository = repository;
	}
	
	public NaturalPerson findOneNaturalPerson(String identification) {
		return repository.findOne(identification);
	}
}
