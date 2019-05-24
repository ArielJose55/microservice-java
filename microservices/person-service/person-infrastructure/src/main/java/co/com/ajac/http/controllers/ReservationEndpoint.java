package co.com.ajac.http.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.models.residents.Reservation;
import co.com.ajac.usecase.reserve.FindAllReserveByState;
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
	
	@PostMapping
	public Integer registerReservation(@Valid @RequestBody Reservation reservation) {
		return registerReserve.execute(reservation);
	}
	
	@GetMapping("/{state}/commons/{common}")
	public List<Reservation> findAllReservationsByState(@PathVariable("state") String state, @PathVariable("common") Integer commonProperty){
		final Tuple2<String, Integer> stateAndCommonProperty = Tuple.of(state, commonProperty);
		return finalAllReserveByState.execute(stateAndCommonProperty).asJava();
	}
}
