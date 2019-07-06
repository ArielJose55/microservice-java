package co.com.ajac.ports;


import co.com.ajac.models.residents.Pet;
import co.com.ajac.models.residents.Resident;
import io.vavr.collection.List;
import io.vavr.control.Option;

public interface ResidentRepository {
	
	public Option<Resident> save(Resident resident);
	
	public Option<Resident> get(String identification);
	
	public Option<Pet> addHimPet(Pet pet, String onwerIdentification);
	
	public List<Pet> listPetsByResident(String onwerIdentification);
	
	public List<Resident> listAllResident();
}
