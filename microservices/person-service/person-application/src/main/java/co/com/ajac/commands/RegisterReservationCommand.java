package co.com.ajac.commands;

import org.springframework.stereotype.Component;

import co.com.ajac.entities.residentes.Reservation;
import commands.Command;

@Component
public class RegisterReservationCommand implements Command<Reservation>{
	
//	private final ReservationService service;
//
//	@Autowired
//	public RegisterReservationCommand(ReservationService service) {
//		this.service = service;
//	}

	@Override
	public void execute(Reservation arg0) {
//		Either<String, Option<Integer>> eitherResult = service.registerReservation(arg0);
//		
//		eitherResult.getOrElseThrow(
//				() -> new NotSaveModelException(eitherResult.getLeft()))
//				.getOrElseThrow(() -> new NotSaveModelException("Ouups! No fue posible registrar su reservacion"));
	}
	
	
}
