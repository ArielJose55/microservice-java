package co.com.ajac.endpoints;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.commands.RegistrarHabitanteCommand;
import co.com.ajac.commands.RegistrarResidenteCommand;
import co.com.ajac.dtos.HabitanteDTO;
import co.com.ajac.dtos.ResidenteDTO;

@RestController
@RequestMapping("/person/api/v1")
public class ResidenteEnpoint {

	private final RegistrarHabitanteCommand registrarHabitanteCommand;
	private final RegistrarResidenteCommand registrarResidenteCommand;
	
	@Autowired
	public ResidenteEnpoint(RegistrarHabitanteCommand registrarHabitanteCommand, RegistrarResidenteCommand registrarResidenteCommand) {
		this.registrarHabitanteCommand = registrarHabitanteCommand;
		this.registrarResidenteCommand = registrarResidenteCommand;
	}
	
	@PostMapping("/habitants")
	public void addHabitante(@Valid @RequestBody HabitanteDTO habitanteDTO) {
		registrarHabitanteCommand.execute(habitanteDTO);
	}
	
	@PostMapping("/residents")
	public void addResidente(@Valid @RequestBody ResidenteDTO residenteDTO) {
		registrarResidenteCommand.execute(residenteDTO);
	}
	
}
