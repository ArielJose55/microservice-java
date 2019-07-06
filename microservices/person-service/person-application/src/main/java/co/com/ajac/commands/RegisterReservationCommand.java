package co.com.ajac.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.models.residents.Reservation;
import co.com.ajac.services.reserve.ReservationService;
import common.Command;
import domain.exceptions.NotSaveModelException;
import io.vavr.control.Either;
import io.vavr.control.Option;

@Component
public class RegisterReservationCommand implements Command<Reservation>{
	
	private final ReservationService service;

	@Autowired
	public RegisterReservationCommand(ReservationService service) {
		this.service = service;
	}

	@Override
	public void execute(Reservation arg0) {
		Either<String, Option<Integer>> eitherResult = service.registerReservation(arg0);
		
		eitherResult.getOrElseThrow(
				() -> new NotSaveModelException(eitherResult.getLeft()))
				.getOrElseThrow(() -> new NotSaveModelException("Ouups! No fue posible registrar su reservacion"));
	}
	
	
}
