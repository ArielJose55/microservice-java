package co.com.ajac.database.repositories;

import java.sql.Timestamp;

import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Repository;

import co.com.ajac.acl.builders.ReservaBuilder;
import co.com.ajac.database.repositories.acl.builders.ReservaDatabaseBuilder;
import co.com.ajac.database.repositories.reserva.ReservaDAO;
import co.com.ajac.entities.residentes.reservas.EstadoReserva;
import co.com.ajac.entities.residentes.reservas.Reserva;
import co.com.ajac.ports.ReservaRepository;
import io.vavr.collection.List;

@Repository
public class ReservaJdbiRepository implements ReservaRepository{

	private final ReservaDAO reservaDAO;
	
	public ReservaJdbiRepository(Jdbi jdbi) {
		this.reservaDAO = jdbi.onDemand(ReservaDAO.class);
	}



	@Override
	public Reserva guardarReservaCompleta(Reserva reserva) {
		reservaDAO.registrarReserva(
				ReservaDatabaseBuilder.crearReservaRecordDesdeEntidad(reserva));
		return reserva;
	}



	@Override
	public List<Reserva> obtenerTodasLasReservasDeUnBienComun(EstadoReserva estadoReserva, Integer bienComun) {
		
		return null;
	}


	@Override
	public List<Reserva> obtenerReservasAprovadasChuzadasConEsta(Reserva reserva) {
		return reservaDAO.listarReservasChuzadasConEstas(
					EstadoReserva.APROVADA.getCodigo(),
					Timestamp.valueOf(reserva.getFechaInicio()),
					Timestamp.valueOf(reserva.getFechaFinalizacion()),
					reserva.getBienComun())
				.map(ReservaDatabaseBuilder::crearReservaDesdeRecord);
	}



	@Override
	public List<Reserva> obtenerReservasPorBienComunYPorEstado(Integer bienComun, EstadoReserva estadoReserva) {
		return reservaDAO.listarTodasLasReservaPorEstadoYPorBienComun(estadoReserva.getCodigo(), bienComun)
				.map(ReservaDatabaseBuilder::crearReservaDesdeRecord);
	}

}
