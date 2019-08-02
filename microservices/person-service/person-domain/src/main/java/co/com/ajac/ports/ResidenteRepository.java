package co.com.ajac.ports;

import co.com.ajac.entities.residentes.Residente;
import co.com.ajac.entities.residentes.habitantes.Habitante;
import coremodel.datosbasicos.Identificacion;
import io.vavr.control.Option;

public interface ResidenteRepository {
	
	Residente guardarResidenteCompleto(Residente resident);
	
	Habitante guardarHabitanteCompleto(Habitante resident);
	
	Option<Residente> obtenerResidentePorSuIdentificacion(Identificacion identification);
	
	Option<Habitante> obtenerHabitantePorSuIdentificacion(Identificacion identification);
		
	//public List<Residente> listAllResident(Integer idPh);
}
