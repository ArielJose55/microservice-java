package co.com.ajac.ports;

import co.com.ajac.entities.residentes.Residente;
import coremodel.persona.personanatural.Identificacion;
import io.vavr.control.Option;

public interface ResidenteRepository {
	
	public Residente guardarResidente(Residente resident);
	
	public Option<Residente> obtenerResidentePorSuIdentificacion(Identificacion identification);
		
	//public List<Residente> listAllResident(Integer idPh);
}
