package co.com.ajac.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.acl.propiedadhorizontal.PropiedadHorizontalCommunicator;
import co.com.ajac.dtos.ResidenteDTO;
import co.com.ajac.services.ResidenteService;
import io.vavr.collection.List;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ResidenteQuery {

	
	private final ResidenteService residenteService;
	private final PropiedadHorizontalCommunicator propiedadHorizontalCommunicator;

	@Autowired
	public ResidenteQuery(ResidenteService residenteService, PropiedadHorizontalCommunicator propiedadHorizontalCommunicator) {
		this.residenteService = residenteService;
		this.propiedadHorizontalCommunicator = propiedadHorizontalCommunicator;
	}
	
	public List<ResidenteDTO> listarResidentePorPropiedadHorizontal(String nit){
		
		//Verificar si la propiedad hotizontal con este nit exite
		
		//traerme todas las propiedades privadas de la PH con este nit
		
		//ir a la base de datos y traerme todos los residentes de las propiedades privadas
		
		throw new UnsupportedOperationException();
	}
	
	public List<ResidenteDTO> listarResidentePorPropiedadPrivada(String idPropiedadPrivada){
		throw new UnsupportedOperationException();
	}
}
