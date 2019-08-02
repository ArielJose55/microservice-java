package co.com.ajac.services;

import co.com.ajac.entities.residentes.reservas.Reserva;
import co.com.ajac.ports.ReservaRepository;

public class ReservaService {

	private final ReservaRepository reservaRepository;

	public ReservaService(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}
	
	public Reserva registrarReserva(Reserva reserva) {
		
		//reglas de negocio
		
		return reservaRepository.registrarReserva(reserva);
	}
}
