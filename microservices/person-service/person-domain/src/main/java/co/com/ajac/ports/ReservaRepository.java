package co.com.ajac.ports;

import co.com.ajac.entities.residentes.reservas.EstadoReserva;
import co.com.ajac.entities.residentes.reservas.Reserva;
import io.vavr.collection.List;

public interface ReservaRepository {

	Reserva guardarReservaCompleta(Reserva reserva);
	
	List<Reserva> obtenerTodasLasReservasDeUnBienComun(EstadoReserva estadoReserva, Integer bienComun);
	
	List<Reserva> obtenerReservasAprovadasChuzadasConEsta(Reserva reserva);
	
	List<Reserva> obtenerReservasPorBienComunYPorEstado(Integer bienComun, EstadoReserva estadoReserva);
}
