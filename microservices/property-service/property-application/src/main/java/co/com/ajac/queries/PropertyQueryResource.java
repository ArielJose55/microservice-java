package co.com.ajac.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.acl.PersonCommunicator;
import co.com.ajac.acl.builders.PropiedadHorizontalBuilder;
import co.com.ajac.domain.phs.Administrador;
import co.com.ajac.dtos.PropiedadHorizontalDTO;
import co.com.ajac.services.horizontal.PropiedadHorizontalService;
import coremodel.excepciones.BusinessException;
import io.vavr.collection.List;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class PropertyQueryResource {
	
	private final PersonCommunicator personCommunicator;
	private final PropiedadHorizontalService horizontalService;
	

	@Autowired
	public PropertyQueryResource(PropiedadHorizontalService horizontalService, PersonCommunicator personCommunicator) {
		this.personCommunicator = personCommunicator;
		this.horizontalService = horizontalService;
	}
	
	
	public List<PropiedadHorizontalDTO> listAllPropetyByAdministrator(Administrador administrador){
		
		log.info("verificando la existencia del administrador con datos: {}, {}", administrador.getTipoIdentificacion(),
				administrador.getNumeroIdentificacion());

		if (!personCommunicator.consultarExistenciaDePersonaJuridica(administrador)) {
			log.error("No existe este administrador {} en el sistema", administrador);
			throw new BusinessException("No existe ningun administrador registrado con identificacion");
		}
		
		 return horizontalService.listarTodasLasPropiedadesHorizontalesPorAdministrador(administrador)
				 .map(PropiedadHorizontalBuilder::crearPropiedadHorizontalDTODesdeEntidad);
	}
	
	/*
	public List<CommonProperty> listAllCommonByHorizontalProperty(String nit) {
		return commonService.findAllCommonByHorizontalProperty(nit).toJavaList();
	}
	
	public CommonProperty getOneCommonProperty(Integer id) {
		Either<String, CommonProperty> eitherResult = commonService.findOneCommonProperty(id);
		return eitherResult.getOrElseThrow(() -> new ModelNotFoundException(eitherResult.getLeft()));
	}
	*/
}
