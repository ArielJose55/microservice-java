package co.com.ajac.usecase.reserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.models.residents.Reservation;
import co.com.ajac.services.reserve.ReservationService;
import common.Query;
import domain.exceptions.NotSaveModelException;
import io.vavr.control.Either;
import io.vavr.control.Option;

@Component
public class RegisterReserve implements Query<Integer, Reservation>{
	
	private final ReservationService service;

	@Autowired
	public RegisterReserve(ReservationService service) {
		this.service = service;
	}

	@Override
	public Integer execute(Reservation arg0) {
		Either<String, Option<Integer>> eitherResult = service.registerReservation(arg0);
		
		return eitherResult.getOrElseThrow(
				() -> new NotSaveModelException(eitherResult.getLeft()))
				.getOrElseThrow(() -> new NotSaveModelException("Ouups! No fue posible registrar su reservacion"));
	}
	
	
}
