package co.com.ajac.ports;

import java.util.List;
import java.util.Optional;

import co.com.ajac.models.residents.Pet;
import co.com.ajac.models.residents.Resident;
import io.vavr.control.Option;

public interface ResidentRepository {
	
	public Option<Resident> save(Resident resident);
	
	public Optional<Resident> get(String identification);
	
	public Optional<Pet> addHimPet(Pet pet, String onwerIdentification);
	
	public Optional<List<Pet>> listPetsByResident(String onwerIdentification);
	
	public Optional<List<Resident>> listAllResident();
}
