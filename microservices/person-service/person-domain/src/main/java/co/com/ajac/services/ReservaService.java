package co.com.ajac.services;

import co.com.ajac.domain.exceptions.BusinessException;
import co.com.ajac.entities.residentes.reservas.EstadoReserva;
import co.com.ajac.entities.residentes.reservas.Reserva;
import co.com.ajac.ports.ReservaRepository;
import io.vavr.collection.List;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ReservaService {

	private final ReservaRepository reservaRepository;

	public ReservaService(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}

	/**
	 * 
	 * @param reserva
	 * @return
	 */
	public Reserva registrarReserva(Reserva reserva) {

		List<Reserva> reservasAprovadas = reservaRepository.obtenerReservasAprovadasChuzadasConEsta(reserva);

		if (reservasAprovadas.isEmpty()) {
			
			// 
			return reservaRepository.guardarReservaCompleta(reserva);
		}
			
		
		throw new BusinessException(reservasAprovadas.map(reservaAprovada -> {
			StringBuilder stb = new StringBuilder("Se presentan conflictos con esta reserva ya aprobada: ");
			stb.append(reservaAprovada);
			return stb.toString();
			
		}).mkString("\n"));
	}
	
	public List<Reserva> obtenerReservasPorBienComunYPorEstado(Integer bienComun, EstadoReserva estadoReserva){
		
		List<Reserva> reservas = reservaRepository.obtenerReservasPorBienComunYPorEstado(bienComun, estadoReserva);
		
		if(reservas.isEmpty()) {
			log.error("No existen reservas en este estado: {} para este bien comun: {}", estadoReserva.getCodigo(), bienComun);
			throw new BusinessException("No existen reservas en este estado: " + estadoReserva.getCodigo() + " para este bien comun: " + bienComun);
		}
		
		return reservas;
	}
}
