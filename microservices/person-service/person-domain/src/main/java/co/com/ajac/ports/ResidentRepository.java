package co.com.ajac.ports;

import co.com.ajac.models.residents.Resident;
import io.vavr.collection.List;
import io.vavr.control.Option;

public interface ResidentRepository {
	
	public Option<Resident> save(Resident resident);
	
	public Option<Resident> get(String identification);
		
	public List<Resident> listAllResident(Integer idPh);
}
