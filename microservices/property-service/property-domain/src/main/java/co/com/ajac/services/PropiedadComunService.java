package co.com.ajac.services;

import co.com.ajac.domain.propiedadeshorizontales.propiedadescomunes.PropiedadComun;
import co.com.ajac.repositories.PropiedadComunRepository;

public class PropiedadComunService {
	
	private final PropiedadComunRepository propiedadComunRepository;

	public PropiedadComunService(PropiedadComunRepository propiedadComunRepository) {
		this.propiedadComunRepository = propiedadComunRepository;
	}
	
	public PropiedadComun registrarPropiedadComun(PropiedadComun propiedadComun) {
		
		return propiedadComunRepository.guardarPropiedadCommun(propiedadComun);
	}

}
