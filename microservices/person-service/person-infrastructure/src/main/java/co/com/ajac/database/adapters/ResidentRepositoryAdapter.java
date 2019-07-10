package co.com.ajac.database.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.database.repositories.ResidentJdbiRepository;
import co.com.ajac.models.residents.Resident;
import co.com.ajac.ports.ResidentRepository;
import io.vavr.collection.List;
import io.vavr.control.Option;

@Component
public class ResidentRepositoryAdapter implements ResidentRepository{

	@Autowired
	private ResidentJdbiRepository repository;

	@Override
	public Option<Resident> save(Resident resident) {
		return repository.create(resident);
	}

	@Override
	public Option<Resident> get(String identification) {
		return repository.get(identification);
	}

	@Override
	public List<Resident> listAllResident(Integer idPh) {
		return repository.getAll();
	}

	

	
	
	
	
}
