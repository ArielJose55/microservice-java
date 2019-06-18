package co.com.ajac.usecase.reserve;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.models.residents.Reservation;
import co.com.ajac.services.reserve.ReservationService;
import common.Query;
import domain.exceptions.ModelNotFoundException;
import io.vavr.control.Either;

@Component
public class FindOneReserveAtDate implements Query<Reservation, LocalDateTime>{

	private final ReservationService service;

	@Autowired
	public FindOneReserveAtDate(ReservationService service) {
		this.service = service;
	}

	@Override
	public Reservation execute(LocalDateTime arg0) {
		Either<String, Reservation> eitherResult = service.findOneReservationActiveAtDate(arg0);
		return eitherResult.getOrElseThrow(
				() -> new ModelNotFoundException(eitherResult.getLeft()));
	}
}
