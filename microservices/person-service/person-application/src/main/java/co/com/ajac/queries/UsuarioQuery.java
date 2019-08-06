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
import io.vavr.control.Try;
import lombok.extern.log4j.Log4j2;

@Log4j2
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
		return userService.obtenerUsuarioPorSuUSername(credencial.getUsername())
				//.filter(user -> use)
				.map(UsuarioBuilder::crearUsuarioDTODesdeEntidad)
				.map(usuario -> {
					if(usuario.getTipoUsuario().compareTo("ADMIN") == 0 || usuario.getTipoUsuario().compareTo("AUXILIAR") == 0) {
						List<PropiedadHorizontalDTO> lista = Try.of(() -> obtenerTodasLasPropiedadesHorizontalesPorAdministrador(
								Identificacion.builder()
								.tipoIdentificacion(usuario.getTipoIdentificacion())
								.numeroIdentificacion(usuario.getNumeroIdentificacion())
								.build())).getOrElse(List.empty());
						
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
		
		if(propiedades.isEmpty()) {
			log.error("Este administrador {} no tiene propiedades horizontales asignadas", identificacion);
			throw new BusinessException("Este administrador no tiene propiedades horizontales asignadas");
		}
		
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
