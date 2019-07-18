package co.com.ajac.database.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.database.repositories.ResidentJdbiRepository;
import co.com.ajac.entities.residentes.Residente;
import co.com.ajac.ports.ResidenteRepository;
import io.vavr.collection.List;
import io.vavr.control.Option;

@Component
public class ResidentRepositoryAdapter implements ResidenteRepository{

	@Autowired
	private ResidentJdbiRepository repository;

	@Override
	public Option<Residente> save(Residente resident) {
		return repository.create(resident);
	}

	@Override
	public Option<Residente> get(String identification) {
		return repository.get(identification);
	}

	@Override
	public List<Residente> listAllResident(Integer idPh) {
		return repository.getAll();
	}

	

	
	
	
	
}
