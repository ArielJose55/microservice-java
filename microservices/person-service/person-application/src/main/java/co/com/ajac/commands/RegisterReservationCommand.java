package co.com.ajac.commands;

import co.com.ajac.entities.residentes.reservas.Reserva;

//@Component
public class RegisterReservationCommand implements Command<Reserva>{
	
//	private final ReservationService service;
//
//	@Autowired
//	public RegisterReservationCommand(ReservationService service) {
//		this.service = service;
//	}

	@Override
	public void execute(Reserva arg0) {
//		Either<String, Option<Integer>> eitherResult = service.registerReservation(arg0);
//		
//		eitherResult.getOrElseThrow(
//				() -> new NotSaveModelException(eitherResult.getLeft()))
//				.getOrElseThrow(() -> new NotSaveModelException("Ouups! No fue posible registrar su reservacion"));
	}
	
	
}
