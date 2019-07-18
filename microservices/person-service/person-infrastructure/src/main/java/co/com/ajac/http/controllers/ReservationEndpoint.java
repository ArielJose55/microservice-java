package co.com.ajac.http.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.commands.RegisterReservationCommand;
import co.com.ajac.entities.residentes.Reservation;
import co.com.ajac.queries.PersonQueryResource;
import io.vavr.Tuple;
import io.vavr.Tuple2;

@RestController
@RequestMapping("/reserve")
public class ReservationEndpoint {

	
	private final RegisterReservationCommand registerReserve;
	
	private final PersonQueryResource personQueryResource;
	
	@Autowired
	public ReservationEndpoint(RegisterReservationCommand registerReserve, PersonQueryResource personQueryResource) {
		this.registerReserve = registerReserve;
		this.personQueryResource = personQueryResource;
	}
	
	@PostMapping
	public void registerReservation(@Valid @RequestBody Reservation reservation) {
		registerReserve.execute(reservation);
	}
	
	@GetMapping("/{state}/commons/{common}")
	public List<Reservation> findAllReservationsByState(@PathVariable("state") String state, @PathVariable("common") Integer commonProperty){
		final Tuple2<String, Integer> stateAndCommonProperty = Tuple.of(state, commonProperty);
		return personQueryResource.findAllReservationByState(stateAndCommonProperty);
	}
	
	@GetMapping("actives/now/{identification}")
	public Reservation findReservationActiveNow(@PathVariable("identification") String identification) {
		return personQueryResource.findOneReservationActiveNowByResident(identification);
	}
	
	@PostMapping("/actives")
	public Reservation findOneReservationAtDate(@Valid @RequestParam @NotBlank String localDateTime) {
	    DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	    LocalDateTime date = dateTimeFormat.parse(localDateTime, LocalDateTime::from);
		
	    return personQueryResource.findOneReservationActiveAtDate(date);
	}
}
