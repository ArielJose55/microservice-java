package co.com.ajac.services;

import co.com.ajac.domain.propiedadeshorizontales.propiedadesprivadas.PropiedadPrivada;
import co.com.ajac.repositories.PropiedadPrivadaRepository;

public class PropiedadPrivadaService {

	private final PropiedadPrivadaRepository privadaRepository;

	public PropiedadPrivadaService(PropiedadPrivadaRepository privadaRepository) {
		this.privadaRepository = privadaRepository;
	}
	
	/**
	 * 
	 * @param propiedadPrivada
	 * @return
	 */
	public PropiedadPrivada registrarNuevaPropiedadPrivada(PropiedadPrivada propiedadPrivada) {
		return privadaRepository.guardarPropiedadPrivada(propiedadPrivada);
	}
	
}
