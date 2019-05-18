package co.com.ajac.database.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.database.repositories.LegalPersonJdbiRepository;
import co.com.ajac.models.LegalDataPerson;
import co.com.ajac.ports.LegalPersonRepository;
import io.vavr.control.Option;

@Component
public class LegalPersonRepositoryAdapter implements LegalPersonRepository {

	@Autowired
	private LegalPersonJdbiRepository repository;

	@Override
	public Option<Integer> registerLegalPerson(LegalDataPerson legalPerson) {
		return repository.saveLegalPerson(legalPerson);
	}

	@Override
	public Option<LegalDataPerson> findLegalPersonBy(String identification) {
		return repository.findByIdentification(identification);
	}
	
}
