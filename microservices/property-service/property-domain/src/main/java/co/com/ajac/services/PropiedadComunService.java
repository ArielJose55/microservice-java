package co.com.ajac.services;

import co.com.ajac.domain.exceptions.BusinessException;
import co.com.ajac.domain.propiedadeshorizontales.propiedadescomunes.PropiedadComun;
import co.com.ajac.repositories.PropiedadComunRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PropiedadComunService {
	
	private final PropiedadComunRepository propiedadComunRepository;

	public PropiedadComunService(PropiedadComunRepository propiedadComunRepository) {
		this.propiedadComunRepository = propiedadComunRepository;
	}
	
	public PropiedadComun registrarPropiedadComun(PropiedadComun propiedadComun) {
		log.debug("Registrando una propiedad comun: {}", propiedadComun);
		return propiedadComunRepository.guardarPropiedadCommun(propiedadComun);
	}

	public PropiedadComun obtenerPropiedadComunPorSuId(Integer idPropiedadComun) {
		return propiedadComunRepository.obtenerPropiedadComun(idPropiedadComun)
				.getOrElseThrow(() -> new BusinessException("No existe ninguna propiedad comun registrada con este ID"));
	}
}
