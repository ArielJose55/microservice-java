package co.com.ajac.services.residente;

import co.com.ajac.entities.residentes.Residente;
import co.com.ajac.ports.ResidenteRepository;
import coremodel.persona.personanatural.Identificacion;
import io.vavr.collection.List;
import io.vavr.control.Option;

public class ResidenteService {

	private final ResidenteRepository residenteRepository;
	
	public ResidenteService(ResidenteRepository residenteRepository) {
		this.residenteRepository = residenteRepository;
	}
	

	public Residente registrarResidente(Residente resident){
		
		return residenteRepository.guardarResidente(resident);
	}
	
	public Option<Residente> obtenerResidente(Identificacion identification){
		
		return residenteRepository.obtenerResidentePorSuIdentificacion(identification);
	}
	
//	public List<Residente> getAll(){
//		return repository.listAllResident(1);
//	}
}
