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
		
		log.debug("Validando el registro de este nuevo residente: {}", resident);
		
		if(residenteRepository.verificarExistenciaDeAlgunaPersonaPorSuIdentificacion(resident.getIdentificacion())) {
			log.error("Ya existe un residente en base de datos con esta identificacion: {}", resident.getIdentificacion());
			throw new BusinessException("Ya existe un residente en base de datos con esta identificacion");
		}
		
		if(residenteRepository.verificarExistenciaDeAlgunaPersonaPorSuHuellaDigital(resident.getDatoBiometrico().getPlantilla())) {
			log.error("Ya existe una persona con esta huella digital registrada en base de datos: {}", resident.getIdentificacion());
			throw new BusinessException("Ya existe una persona con esta huella digital registrada en base de dato");
		}
		
		if(residenteRepository.verificarExistenciaDeAlgunaPersonaPorSuCodigoseguridad(resident.getDatoBiometrico().getCodigoDeSeguridad())) {
			log.error("Ya existe una persona con este codigo de seguridad registrada en base de datos: {}", resident.getIdentificacion());
			throw new BusinessException("Ya existe una persona con este codigo de seguridad registrada en base de dato");
		}
		
		log.debug("Validacion completa, se procede a guardar el residente en el base de datos");
		
		return residenteRepository.guardarResidenteCompleto(resident);
	}
	
	public Habitante registrarHabitanteAUnResidente(Habitante habitante) {
	
		log.debug("Validando el registro de este nuevo habitante: {}", habitante);
		
		if(residenteRepository.verificarExistenciaDeAlgunaPersonaPorSuIdentificacion(habitante.getIdentificacion())) {
			log.error("Ya existe un habitante en base de datos con esta identificacion: {}", habitante.getIdentificacion());
			throw new BusinessException("Ya existe un habitante en base de datos con esta identificacion");
		}
		
		if(residenteRepository.verificarExistenciaDeAlgunaPersonaPorSuHuellaDigital(habitante.getDatoBiometrico().getPlantilla())) {
			log.error("Ya existe una persona con esta huella digital registrada en base de datos: {}", habitante.getIdentificacion());
			throw new BusinessException("Ya existe una persona con esta huella digital registrada en base de dato");
		}
		
		if(residenteRepository.verificarExistenciaDeAlgunaPersonaPorSuCodigoseguridad(habitante.getDatoBiometrico().getCodigoDeSeguridad())) {
			log.error("Ya existe una persona con este codigo de seguridad registrada en base de datos: {}", habitante.getIdentificacion());
			throw new BusinessException("Ya existe una persona con este codigo de seguridad registrada en base de dato");
		}
		
		log.debug("Validacion completa, se procede a guardar el habitante en el base de datos");
		
		//Demas reglas de negocio
		
		return residenteRepository.guardarHabitanteCompleto(habitante);
		
	}
	
	/**
	 * 
	 * @param identification
	 * @return
	 */
	public Option<Residente> obtenerResidente(Identificacion identification){
		
		return residenteRepository.obtenerResidentePorSuIdentificacion(identification);
	}
	
	
}
