package co.com.ajac.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.acl.builders.ReservaBuilder;
import co.com.ajac.dtos.ReservaDTO;
import co.com.ajac.entities.residentes.reservas.EstadoReserva;
import co.com.ajac.services.ReservaService;
import io.vavr.collection.List;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ReservaQuery {
	
	private final ReservaService reservaService;

	@Autowired
	public ReservaQuery(ReservaService reservaService) {
		this.reservaService = reservaService;
	}
	
	public List<ReservaDTO> listarTodasLasReservas(Integer bienComun, String estadoReserva){
		log.debug("Obteniendo las reservas en este estado {} y para esta reservas {}", estadoReserva, bienComun);
		return reservaService.obtenerReservasPorBienComunYPorEstado(bienComun, EstadoReserva.getEstadoReservaDesdeCodigo(estadoReserva))
				.map(ReservaBuilder::crearReservaDTODesdeEntidad);
	}

}
