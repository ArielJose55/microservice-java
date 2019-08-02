package co.com.ajac.endpoints;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.commands.RegistrarHabitanteCommand;
import co.com.ajac.dtos.HabitanteDTO;

@RestController
@RequestMapping("/person/api/v1")
public class ResidenteEnpoint {

	private final RegistrarHabitanteCommand registrarHabitanteCommand;

	@Autowired
	public ResidenteEnpoint(RegistrarHabitanteCommand registrarHabitanteCommand) {
		this.registrarHabitanteCommand = registrarHabitanteCommand;
	}
	
	@PostMapping("/habitants")
	public void add(@Valid @RequestBody HabitanteDTO habitanteDTO) {
		registrarHabitanteCommand.execute(habitanteDTO);
	}
	
	
}
