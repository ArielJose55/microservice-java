package co.com.ajac.database.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.database.repositories.LegalPersonJdbiRepository;
import co.com.ajac.ports.AdministradorRepository;
import coremodel.LegalPerson;
import io.vavr.control.Option;

@Component
public class LegalPersonRepositoryAdapter implements AdministradorRepository {

	
	private final LegalPersonJdbiRepository repository;
	
	@Autowired
	public LegalPersonRepositoryAdapter(LegalPersonJdbiRepository repository) {
		this.repository = repository;
	}

	@Override
	public Option<Integer> registerLegalPerson(LegalPerson legalPerson) {
		return repository.saveLegalPerson(legalPerson);
	}

	@Override
	public Option<LegalPerson> findLegalPersonBy(String identification) {
		return repository.findByIdentification(identification);
	}
	
}
