package co.com.ajac.http.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.commands.RegisterResidentCommand;
import co.com.ajac.models.residents.Resident;
import co.com.ajac.queries.PersonQueryResource;

@RestController
@RequestMapping("/residents")
public class ResidentController {
	
	private final RegisterResidentCommand createResident;
	
	private final PersonQueryResource personQueryResource;
		
	@Autowired
	public ResidentController(RegisterResidentCommand createResident, PersonQueryResource personQueryResource) {
		this.createResident = createResident;
		this.personQueryResource = personQueryResource;
	}

	@PostMapping
	public void add(@Valid @RequestBody Resident resident) {
		createResident.execute(resident);
	}
	
	@GetMapping("/{id}")
	public Resident get(@PathVariable("id") String identification) {
		return personQueryResource.findOneResidentByIdentification(identification);
	}
	
	@GetMapping("/hp/{id}")
	public List<Resident> getAll(@PathVariable("id") Integer idHp){
		return personQueryResource.findAllResidentByHorizontalProperty(idHp);
	}
	
}
