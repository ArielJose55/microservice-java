package co.com.ajac.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.acl.builders.ReservaBuilder;
import co.com.ajac.dtos.ReservaDTO;
import co.com.ajac.services.ReservaService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class RegistrarReservaCommand implements Command<ReservaDTO>{
	
	private final ReservaService reservaService;

	@Autowired
	public RegistrarReservaCommand(ReservaService reservaService) {
		this.reservaService = reservaService;
	}

	@Override
	public void execute(ReservaDTO reservaDTO) {
		log.debug("Ejecutando el comando: RegistrarReservaCommand con los datos: {}", reservaDTO);
		reservaService.registrarReserva(ReservaBuilder.crearReservaDesdeRequest(reservaDTO));
	}

	
}
