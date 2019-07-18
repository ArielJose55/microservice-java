package co.com.ajac.services.horizontal;

import co.com.ajac.domain.phs.Administrador;
import co.com.ajac.domain.phs.PropiedadHorizontal;
import co.com.ajac.repositories.PropiedadHorizontalRepository;
import coremodel.excepciones.BusinessException;
import io.vavr.collection.List;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class PropiedadHorizontalService {

	private final PropiedadHorizontalRepository propiedadHorizontalRepository;

	public PropiedadHorizontalService(PropiedadHorizontalRepository propiedadHorizontalRepository) {
		this.propiedadHorizontalRepository = propiedadHorizontalRepository;
	}
	
	public PropiedadHorizontal registrarrHorizontalProperty(PropiedadHorizontal propiedadHorizontal) {
		
		if(propiedadHorizontalRepository.obtenerPropiedadHorizontalPorNit(propiedadHorizontal.getNit()).isDefined()) {
			log.error("Ya existe en el sistema una propiedad horizontal con este nit: {}", propiedadHorizontal.getNit());
			throw new BusinessException("Ya existe en el sistema una propiedad horizontal con este NIT");
		}
		log.debug("Se procede a registrar la siguiente propiedad horizontal: {}", propiedadHorizontal);
		return propiedadHorizontalRepository.registrarPropiedadHorizontal(propiedadHorizontal);
	}
	
	public List<PropiedadHorizontal> listarTodasLasPropiedadesHorizontalesPorAdministrador(Administrador administrador){
		
		List<PropiedadHorizontal> propiedades =
				propiedadHorizontalRepository.obtenerTodasPropiedadesHorizontalesPorAdministrador(administrador);
		
		if(propiedades.isEmpty())
			throw new BusinessException("Este administrador no tiene registradas propiedades horizontales");
		
		return propiedades;
	}
	
}
