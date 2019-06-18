package co.com.ajac.http.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

import co.com.ajac.models.residents.Reservation;
import co.com.ajac.usecase.reserve.FindAllReserveByState;
import co.com.ajac.usecase.reserve.FindOneReserveActiveNow;
import co.com.ajac.usecase.reserve.FindOneReserveAtDate;
import co.com.ajac.usecase.reserve.RegisterReserve;
import io.vavr.Tuple;
import io.vavr.Tuple2;

@RestController
@RequestMapping("/reserve")
public class ReservationEndpoint {

	@Autowired
	private RegisterReserve registerReserve;
	
	@Autowired
	private FindAllReserveByState finalAllReserveByState;
	
	@Autowired
	private FindOneReserveActiveNow findOneReserveActiveNow;
	
	@Autowired
	private FindOneReserveAtDate findOneReserveAtDate;
	
	@PostMapping
	public Integer registerReservation(@Valid @RequestBody Reservation reservation) {
		return registerReserve.execute(reservation);
	}
	
	@GetMapping("/{state}/commons/{common}")
	public List<Reservation> findAllReservationsByState(@PathVariable("state") String state, @PathVariable("common") Integer commonProperty){
		final Tuple2<String, Integer> stateAndCommonProperty = Tuple.of(state, commonProperty);
		return finalAllReserveByState.execute(stateAndCommonProperty).asJava();
	}
	
	@GetMapping("actives/now/{identification}")
	public Reservation findReservationActiveNow(@PathVariable("identification") String identification) {
		return findOneReserveActiveNow.execute(identification);
	}
	
	@PostMapping("/actives")
	public Reservation findOneReservationAtDate(@Valid @RequestParam @NotBlank String localDateTime) {
	    DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	    LocalDateTime date = dateTimeFormat.parse(localDateTime, LocalDateTime::from);
		
		return findOneReserveAtDate.execute(date);
	}
}
