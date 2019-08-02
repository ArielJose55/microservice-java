package co.com.ajac.ports;

import co.com.ajac.entities.residentes.reservas.Reserva;

public interface ReservaRepository {

	Reserva registrarReserva(Reserva reserva);
}
