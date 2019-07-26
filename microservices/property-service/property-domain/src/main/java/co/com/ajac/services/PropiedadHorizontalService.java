package co.com.ajac.services;

import co.com.ajac.domain.exceptions.BusinessException;
import co.com.ajac.domain.propiedadeshorizontales.Administrador;
import co.com.ajac.domain.propiedadeshorizontales.PropiedadHorizontal;
import co.com.ajac.domain.propiedadeshorizontales.propiedadescomunes.PropiedadComun;
import co.com.ajac.domain.propiedadeshorizontales.propiedadesprivadas.PropiedadPrivada;
import co.com.ajac.repositories.PropiedadComunRepository;
import co.com.ajac.repositories.PropiedadHorizontalRepository;
import co.com.ajac.repositories.PropiedadPrivadaRepository;
import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class PropiedadHorizontalService {

	private final PropiedadHorizontalRepository propiedadHorizontalRepository;
	private final PropiedadComunRepository propiedadComunRepository;
	private final PropiedadPrivadaRepository propiedadPrivadaRepository;
	
	
	
	public PropiedadHorizontalService(PropiedadHorizontalRepository propiedadHorizontalRepository,
			PropiedadComunRepository propiedadComunRepository, PropiedadPrivadaRepository propiedadPrivadaRepository) {
		this.propiedadHorizontalRepository = propiedadHorizontalRepository;
		this.propiedadComunRepository = propiedadComunRepository;
		this.propiedadPrivadaRepository = propiedadPrivadaRepository;
	}

	/**
	 * 
	 * @param propiedadHorizontal
	 * @return
	 */
	public PropiedadHorizontal registrarrHorizontalProperty(PropiedadHorizontal propiedadHorizontal) {
		
		if(propiedadHorizontalRepository.obtenerPropiedadHorizontalPorNit(propiedadHorizontal.getNit()).isDefined()) {
			log.error("Ya existe en el sistema una propiedad horizontal con este nit: {}", propiedadHorizontal.getNit());
			throw new BusinessException("Ya existe en el sistema una propiedad horizontal con este NIT");
		}
		log.debug("Se procede a registrar la siguiente propiedad horizontal: {}", propiedadHorizontal);
		return propiedadHorizontalRepository.registrarPropiedadHorizontal(propiedadHorizontal);
	}
	
	/**
	 * 
	 * @param administrador
	 * @return
	 */
	public List<PropiedadHorizontal> listarTodasLasPropiedadesHorizontalesPorAdministrador(Administrador administrador){
		
		List<PropiedadHorizontal> propiedades =
				propiedadHorizontalRepository.obtenerTodasPropiedadesHorizontalesPorAdministrador(administrador);
		
		if(propiedades.isEmpty())
			throw new BusinessException("Este administrador no tiene registradas propiedades horizontales");
		
		return propiedades;
	}
	
	/**
	 * 
	 * @param nit
	 * @return
	 */
	public PropiedadHorizontal obtenerPropiedadHorizontalCompletaPorNit(String nit) {
		
		Option<PropiedadHorizontal> propiedadHorizontal = propiedadHorizontalRepository.obtenerPropiedadHorizontalPorNit(nit);
		
		if(!propiedadHorizontal.isDefined()) {
			log.error("No existe en el sistema una propiedad horizontal con este nit: {}", nit);
			throw new BusinessException("No existe en el sistema una propiedad horizontal con este NIT");
		}
		
		log.debug("Obteniendo las propiedades comunes y privadas de este nit: {}", nit);
		List<PropiedadComun> propiedadesComunes = propiedadComunRepository.obtenerPropiedadesComunesDeUnaPropiedadHorizontal(nit);
		List<PropiedadPrivada> propiedadesPrivadas = propiedadPrivadaRepository.obtenerPropiedadesComunesDeUnaPropiedadHorizontal(nit);
		
		return propiedadHorizontal.map(propiedad -> PropiedadHorizontal.builder()
				.administrador(propiedad.getAdministrador())
				.nit(nit)
				.nombreDistintivo(propiedad.getNombreDistintivo())
				.bienesCommunes(propiedadesComunes)
				.bienesPrivados(propiedadesPrivadas)
				.build())
				.getOrElseThrow(() -> new BusinessException("No existe en el sistema una propiedad horizontal con este NIT"));
	}
	
	/**
	 * 
	 * @param nit
	 * @return
	 */
	public PropiedadHorizontal obtenerPropiedadHorizontalPorNit(String nit) {
		
		Option<PropiedadHorizontal> propiedadHorizontal = propiedadHorizontalRepository.obtenerPropiedadHorizontalPorNit(nit);
		
		if(!propiedadHorizontal.isDefined()) {
			log.error("No existe en el sistema una propiedad horizontal con este nit: {}", nit);
			throw new BusinessException("No existe en el sistema una propiedad horizontal con este NIT");
		}	
		
		return propiedadHorizontal.map(propiedad -> PropiedadHorizontal.builder()
				.administrador(propiedad.getAdministrador())
				.nit(nit)
				.nombreDistintivo(propiedad.getNombreDistintivo())
				.build())
				.getOrElseThrow(() -> new BusinessException("No existe en el sistema una propiedad horizontal con este NIT"));
	}
	
}
