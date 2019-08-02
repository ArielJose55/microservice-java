package co.com.ajac.services;

import co.com.ajac.domain.exceptions.BusinessException;
import co.com.ajac.entities.residentes.Residente;
import co.com.ajac.entities.residentes.habitantes.Habitante;
import co.com.ajac.ports.ResidenteRepository;
import coremodel.datosbasicos.Identificacion;
import io.vavr.control.Option;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ResidenteService {

	private final ResidenteRepository residenteRepository;
	
	public ResidenteService(ResidenteRepository residenteRepository) {
		this.residenteRepository = residenteRepository;
	}
	

	public Residente registrarResidente(Residente resident){
		
		if(residenteRepository.obtenerResidentePorSuIdentificacion(resident.getIdentificacion()).isDefined()) {
			log.error("Ya existe un residente en base de datos con esta identificacion: {}", resident.getIdentificacion());
			throw new BusinessException("Ya existe un residente en base de datos con esta identificacion");
		}
		
		return residenteRepository.guardarResidenteCompleto(resident);
	}
	
	public Habitante registrarHabitanteAUnResidente(Habitante habitante, Identificacion identificacionResidente) {
		
		if(residenteRepository.obtenerResidentePorSuIdentificacion(identificacionResidente).isDefined()) {
			log.error("Ya existe un residente en base de datos con esta identificacion: {}", identificacionResidente);
			throw new BusinessException("Ya existe un residente en base de datos con esta identificacion");
		}
		
		if(residenteRepository.obtenerHabitantePorSuIdentificacion(habitante.getIdentificacion()).isDefined()) {
			log.error("Ya existe un residente en base de datos con esta identificacion: {}", habitante.getIdentificacion());
			throw new BusinessException("Ya existe un residente en base de datos con esta identificacion");
		}
		
		//Demas reglas de negocio
		
		return residenteRepository.guardarHabitanteCompleto(habitante);
		
	}
	
	public Option<Residente> obtenerResidente(Identificacion identification){
		
		return residenteRepository.obtenerResidentePorSuIdentificacion(identification);
	}
	
//	public List<Residente> getAll(){
//		return repository.listAllResident(1);
//	}
}
