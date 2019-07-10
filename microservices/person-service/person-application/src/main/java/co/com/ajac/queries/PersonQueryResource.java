package co.com.ajac.queries;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.dtos.UserDTO;
import co.com.ajac.models.User;
import co.com.ajac.models.residents.Reservation;
import co.com.ajac.models.residents.Resident;
import co.com.ajac.services.legalperson.LegalPersonService;
import co.com.ajac.services.naturalperson.NaturalPersonService;
import co.com.ajac.services.reserve.ReservationService;
import co.com.ajac.services.resident.ResidentService;
import co.com.ajac.services.user.UserService;
import coremodel.LegalPerson;
import coremodel.NaturalPerson;
import domain.exceptions.ModelNotFoundException;
import io.vavr.Tuple2;
import io.vavr.control.Either;

@Component
public class PersonQueryResource {

	private static final String USER_NOT_FOUND = "El usuario con esta identificación no existe";
	private static final String RESIDENT_NOT_FOUND = "El residente con esta identificación no existe";

	private final LegalPersonService legalPersonService;
	private final ReservationService reservationService;
	private final ResidentService residentService;
	private final UserService userService;
	private final NaturalPersonService naturalPersonService;

	@Autowired
	public PersonQueryResource(LegalPersonService legalPersonService, ReservationService reservationService,
			ResidentService residentService, UserService userService, NaturalPersonService naturalPersonService) {
		this.legalPersonService = legalPersonService;
		this.reservationService = reservationService;
		this.residentService = residentService;
		this.userService = userService;
		this.naturalPersonService = naturalPersonService;
	}

	public LegalPerson findOneLegalPerson(String identification) {
		Either<String, LegalPerson> findOne = legalPersonService.findOneLegalPerson(identification);
		return findOne.getOrElseThrow(() -> new ModelNotFoundException(findOne.getLeft()));
	}

	public List<Reservation> findAllReservationByState(Tuple2<String, Integer> arg0) {
		Either<String, io.vavr.collection.List<Reservation>> eitherResult = reservationService
				.findAllReservationByState(arg0._1, arg0._2);
		return eitherResult.getOrElseThrow(() -> new ModelNotFoundException(eitherResult.getLeft())).toJavaList();
	}

	public Reservation findOneReservationActiveNowByResident(String arg0) {
		Either<String, Reservation> eitherResult = reservationService.findOneReservationActiveNowByResident(arg0);
		return eitherResult.getOrElseThrow(() -> new ModelNotFoundException(eitherResult.getLeft()));
	}

	public Reservation findOneReservationActiveAtDate(LocalDateTime arg0) {
		Either<String, Reservation> eitherResult = reservationService.findOneReservationActiveAtDate(arg0);
		return eitherResult.getOrElseThrow(() -> new ModelNotFoundException(eitherResult.getLeft()));
	}

	public List<Resident> findAllResidentByHorizontalProperty(Integer idHorizontalProperty) {
		return residentService.getAll().toJavaList(); //Falta Implementacion
	}

	public Resident findOneResidentByIdentification(String identification) {
		return residentService.get(identification).getOrElseThrow(() -> new ModelNotFoundException(RESIDENT_NOT_FOUND));
	}

	public User findOneUserByIdentification(String identification) {
		return userService.findOneBy(identification).orElseThrow(() -> new ModelNotFoundException(USER_NOT_FOUND));
	}

	public UserDTO login(User userDTO) {

		User user = userService.login(userDTO.getUsername(), userDTO.getPassword());

		NaturalPerson naturalPerson = naturalPersonService.findOneNaturalPerson(user.getIdentification());

		return UserDTO.builder()
				.username(user.getUsername())
				.identification(user.getIdentification())
				.token("dddd")
				.names(naturalPerson.getName()).lastName(naturalPerson.getLastName())
				.completeName(naturalPerson.getName().concat(" ").concat(naturalPerson.getLastName()))
				.role(user.getRole()).build();

	}

}
