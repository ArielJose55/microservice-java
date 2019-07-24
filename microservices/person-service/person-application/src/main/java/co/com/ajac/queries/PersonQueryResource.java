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
public class PersonQueryResource {

//	private final AdministradorService legalPersonService;
//	private final ReservationService reservationService;
//	private final ResidenteService residentService;
	private final UsuarioService userService;
	private final PersonaJuridicaService personaJuridicaService;
	private final PropiedadHorizontalCommunicator propiedadHorizontalCommunicator;

	@Autowired
	public PersonQueryResource(
			UsuarioService userService,
			PersonaJuridicaService personaJuridicaService,
			PropiedadHorizontalCommunicator propiedadHorizontalCommunicator) {
		this.userService = userService;
		this.personaJuridicaService = personaJuridicaService;
		this.propiedadHorizontalCommunicator = propiedadHorizontalCommunicator;
	}

	public UsuarioDTO obtenerUsuarioPorSuIdentificacion(Identificacion identification) {
		return userService.obtenerUsuarioPorSusIdentificacion(identification)
				.map(UsuarioBuilder::crearUsuarioDTODesdeEntidad)
				.getOrElseThrow(() -> new BusinessException("No existe ningun usuario con esta identificacion"));
	}
	
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
	
	public PersonaJuridica obtenerPersonaJuridicaPorNit(String nit) {
		return personaJuridicaService.obtenerPersonaJuridicaPorSuNit(nit);
	}
	
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
	

//	public List<Reservation> findAllReservationByState(Tuple2<String, Integer> arg0) {
//		Either<String, io.vavr.collection.List<Reservation>> eitherResult = reservationService
//				.findAllReservationByState(arg0._1, arg0._2);
//		return eitherResult.getOrElseThrow(() -> new ModelNotFoundException(eitherResult.getLeft())).toJavaList();
//	}


//
//	public Reservation findOneReservationActiveAtDate(LocalDateTime arg0) {
//		Either<String, Reservation> eitherResult = reservationService.findOneReservationActiveAtDate(arg0);
//		return eitherResult.getOrElseThrow(() -> new ModelNotFoundException(eitherResult.getLeft()));
//	}
//
//	public List<Residente> findAllResidentByHorizontalProperty(Integer idHorizontalProperty) {
//		return residentService.getAll().toJavaList(); //Falta Implementacion
//	}
//
//	public Residente findOneResidentByIdentification(String identification) {
//		return residentService.get(identification).getOrElseThrow(() -> new ModelNotFoundException(RESIDENT_NOT_FOUND));
//	}
//
//	public Usuario findOneUserByIdentification(String identification) {
//		return userService.findOneBy(identification).orElseThrow(() -> new ModelNotFoundException(USER_NOT_FOUND));
//	}

//	public UsuarioDTO login(Usuario userDTO) {
//
//		Usuario user = userService.login(userDTO.getUsername(), userDTO.getPassword());
//
//		NaturalPerson naturalPerson = naturalPersonService.findOneNaturalPerson(user.getIdentification());
//
//		return UsuarioDTO.builder()
//				.username(user.getUsername())
//				.identification(user.getIdentification())
//				.token("dddd")
//				.names(naturalPerson.getName()).lastName(naturalPerson.getLastName())
//				.completeName(naturalPerson.getName().concat(" ").concat(naturalPerson.getLastName()))
//				.role(user.getRole()).build();
//
//	}

}
