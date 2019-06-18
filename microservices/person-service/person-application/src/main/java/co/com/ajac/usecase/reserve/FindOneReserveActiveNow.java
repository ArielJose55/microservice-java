package co.com.ajac.usecase.reserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.models.residents.Reservation;
import co.com.ajac.services.reserve.ReservationService;
import common.Query;
import domain.exceptions.ModelNotFoundException;
import io.vavr.control.Either;

@Component
public class FindOneReserveActiveNow  implements Query<Reservation, String>{

	private final ReservationService service;

	@Autowired
	public FindOneReserveActiveNow(ReservationService service) {
		this.service = service;
	}

	@Override
	public Reservation execute(String arg0) {
		Either<String, Reservation> eitherResult = service.findOneReservationActiveNowByResident(arg0);
		return eitherResult.getOrElseThrow(
				() -> new ModelNotFoundException(eitherResult.getLeft()));
	}
		
}
