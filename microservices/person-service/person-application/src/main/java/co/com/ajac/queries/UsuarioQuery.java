package co.com.ajac.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.acl.builders.UsuarioBuilder;
import co.com.ajac.acl.propiedadhorizontal.PropiedadHorizontalCommunicator;
import co.com.ajac.acl.propiedadhorizontal.modelos.PropiedadHorizontalDTO;
import co.com.ajac.domain.exceptions.BusinessException;
import co.com.ajac.dtos.UsuarioDTO;
import co.com.ajac.entities.personasjuridicas.PersonaJuridica;
import co.com.ajac.entities.usuarios.Credencial;
import co.com.ajac.services.PersonaJuridicaService;
import co.com.ajac.services.UsuarioService;
import coremodel.datosbasicos.Identificacion;
import io.vavr.collection.List;

@Component
public class UsuarioQuery {

	private final UsuarioService userService;
	private final PersonaJuridicaService personaJuridicaService;
	private final PropiedadHorizontalCommunicator propiedadHorizontalCommunicator;

	@Autowired
	public UsuarioQuery(UsuarioService userService, PersonaJuridicaService personaJuridicaService,
			PropiedadHorizontalCommunicator propiedadHorizontalCommunicator) {
		this.userService = userService;
		this.personaJuridicaService = personaJuridicaService;
		this.propiedadHorizontalCommunicator = propiedadHorizontalCommunicator;
	}
	
	/**
	 * 
	 * @param identification
	 * @return
	 */
	public UsuarioDTO obtenerUsuarioPorSuIdentificacion(Identificacion identification) {
		return userService.obtenerUsuarioPorSusIdentificacion(identification)
				.map(UsuarioBuilder::crearUsuarioDTODesdeEntidad)
				.getOrElseThrow(() -> new BusinessException("No existe ningun usuario con esta identificacion"));
	}
	
	/**
	 * 
	 * @param credencial
	 * @return
	 */
	public UsuarioDTO obtenerUsuarioPorSusCredenciales(Credencial credencial) {
		return userService.obtenerUsuarioPorSusCredenciales(credencial)
				.map(UsuarioBuilder::crearUsuarioDTODesdeEntidad)
				.map(usuario -> {
					if(usuario.getTipoUsuario().compareTo("ADM") == 0 || usuario.getTipoUsuario().compareTo("AUX") == 0) {
						List<PropiedadHorizontalDTO> lista = obtenerTodasLasPropiedadesHorizontalesPorAdministrador(
								Identificacion.builder()
								.tipoIdentificacion(usuario.getTipoIdentificacion())
								.numeroIdentificacion(usuario.getNumeroIdentificacion())
								.build());
						
						usuario.setPropiedades(lista.asJava());
					}
					return usuario;
				})
				.getOrElseThrow(() -> new BusinessException("No existe ningun usuario con este username y/o password"));
		
	}
	
	/**
	 * 
	 * @param identificacion
	 * @return
	 */
	public List<PropiedadHorizontalDTO> obtenerTodasLasPropiedadesHorizontalesPorAdministrador(Identificacion identificacion){
		
		List<PropiedadHorizontalDTO> propiedades =  propiedadHorizontalCommunicator
			.obtenerTodasLasPropiedadesHorizontalesDeUnAdministrador(identificacion);
		
		return propiedades.map(propiedad -> {
			PersonaJuridica personaJuridica = personaJuridicaService.obtenerPersonaJuridicaPorSuNit(propiedad.getNit());
			return PropiedadHorizontalDTO.builder()
					.nit(propiedad.getNit())
					.nombreDistintivo(propiedad.getNombreDistintivo())
					.objetoSocial(personaJuridica.getObjetoSocial())
					.razonSocial(personaJuridica.getRazonSocial())
					.build();
		});
	}
	
}
