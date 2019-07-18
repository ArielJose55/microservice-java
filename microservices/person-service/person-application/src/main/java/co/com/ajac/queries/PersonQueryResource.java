package co.com.ajac.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.services.usuario.UsuarioService;

@Component
public class PersonQueryResource {

	private static final String USER_NOT_FOUND = "El usuario con esta identificación no existe";
	private static final String RESIDENT_NOT_FOUND = "El residente con esta identificación no existe";

//	private final AdministradorService legalPersonService;
//	private final ReservationService reservationService;
//	private final ResidenteService residentService;
	private final UsuarioService userService;
//	private final NaturalPersonService naturalPersonService;

	@Autowired
	public PersonQueryResource(UsuarioService userService) {
		this.userService = userService;
	}

//	public LegalPerson findOneLegalPerson(String identification) {
//		Either<String, LegalPerson> findOne = legalPersonService.findOneLegalPerson(identification);
//		return findOne.getOrElseThrow(() -> new ModelNotFoundException(findOne.getLeft()));
//	}
//
//	public List<Reservation> findAllReservationByState(Tuple2<String, Integer> arg0) {
//		Either<String, io.vavr.collection.List<Reservation>> eitherResult = reservationService
//				.findAllReservationByState(arg0._1, arg0._2);
//		return eitherResult.getOrElseThrow(() -> new ModelNotFoundException(eitherResult.getLeft())).toJavaList();
//	}

//	public Reservation findOneReservationActiveNowByResident(String arg0) {
//		Either<String, Reservation> eitherResult = reservationService.findOneReservationActiveNowByResident(arg0);
//		return eitherResult.getOrElseThrow(() -> new ModelNotFoundException(eitherResult.getLeft()));
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
