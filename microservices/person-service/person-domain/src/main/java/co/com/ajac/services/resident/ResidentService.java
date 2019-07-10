package co.com.ajac.services.resident;

import co.com.ajac.models.residents.Resident;
import co.com.ajac.ports.ResidentRepository;
import io.vavr.collection.List;
import io.vavr.control.Option;

public class ResidentService {


	private final ResidentRepository repository;
	
	/**
	 * @param repository
	 */
	public ResidentService(ResidentRepository repository) {
		this.repository = repository;
	}

	public Option<Resident> create(Resident resident){
		return repository.save(resident);
	}
	
	public Option<Resident> get(String identification){
		return repository.get(identification);
	}
	
	public List<Resident> getAll(){
		return repository.listAllResident(1);
	}
}
