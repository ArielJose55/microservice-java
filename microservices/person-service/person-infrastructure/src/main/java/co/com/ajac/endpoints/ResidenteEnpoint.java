package co.com.ajac.endpoints;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.commands.RegistrarHabitanteCommand;
import co.com.ajac.commands.RegistrarReservaCommand;
import co.com.ajac.commands.RegistrarResidenteCommand;
import co.com.ajac.dtos.HabitanteDTO;
import co.com.ajac.dtos.ReservaDTO;
import co.com.ajac.dtos.ResidenteDTO;
import co.com.ajac.queries.ReservaQuery;
import co.com.ajac.queries.ResidenteQuery;

@RestController
@RequestMapping("/person/api/v1")
public class ResidenteEnpoint {

	private final RegistrarHabitanteCommand registrarHabitanteCommand;
	private final RegistrarResidenteCommand registrarResidenteCommand;
	private final RegistrarReservaCommand registrarReservaCommand;
	private final ReservaQuery reservaQuery;
	private final ResidenteQuery residenteQuery;
	
	@Autowired
	public ResidenteEnpoint(
			RegistrarHabitanteCommand registrarHabitanteCommand,
			RegistrarResidenteCommand registrarResidenteCommand,
			RegistrarReservaCommand registrarReservaCommand,
			ReservaQuery reservaQuery,
			ResidenteQuery residenteQuery) {
		this.registrarHabitanteCommand = registrarHabitanteCommand;
		this.registrarResidenteCommand = registrarResidenteCommand;
		this.registrarReservaCommand = registrarReservaCommand;
		this.reservaQuery = reservaQuery;
		this.residenteQuery = residenteQuery;
	}
	
	@PostMapping("/habitants")
	public void registrarHabitante(@Valid @RequestBody HabitanteDTO habitanteDTO) {
		registrarHabitanteCommand.execute(habitanteDTO);
	}
	
	@PostMapping("/residents")
	public void registrarResidente(@Valid @RequestBody ResidenteDTO residenteDTO) {
		registrarResidenteCommand.execute(residenteDTO);
	}
	
	@PostMapping("/reservations")
	public void registrarReserva(@Valid @RequestBody ReservaDTO reservaDTO) {
		registrarReservaCommand.execute(reservaDTO);
	}
	
	@GetMapping("/reservations/{estadoReserva}/{idPropiedadComun}")
	public List<ReservaDTO> listarReservas(@PathVariable("estadoReserva") String estadoReserva, @PathVariable("idPropiedadComun") Integer idPropiedadComun){
		return reservaQuery.listarTodasLasReservas(idPropiedadComun, estadoReserva)
				.toJavaList();
	}
	
	@GetMapping("/residents/ph/{nit}")
	public List<ResidenteDTO> listarResidenteDeunaPropiedadHorizontal(
			@PathVariable("nit") String nit){
		res
	}
}
