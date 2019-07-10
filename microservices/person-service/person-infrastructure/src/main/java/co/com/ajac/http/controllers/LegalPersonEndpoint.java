package co.com.ajac.http.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.commands.RegisterLegalPersonCommand;
import co.com.ajac.queries.PersonQueryResource;
import coremodel.LegalPerson;

@RestController
@RequestMapping("/legalperson")
public class LegalPersonEndpoint {
	
	private final RegisterLegalPersonCommand reLegalPerson;
	private final PersonQueryResource personQueryResource;

	@Autowired
	public LegalPersonEndpoint(RegisterLegalPersonCommand reLegalPerson, PersonQueryResource personQueryResource) {
		this.reLegalPerson = reLegalPerson;
		this.personQueryResource = personQueryResource;
	}
	
	@PostMapping
	public void registerLegalPerson(@Valid @RequestBody LegalPerson legalDataPerson) {
		 reLegalPerson.execute(legalDataPerson);
	}
	
	@GetMapping("/{identification}")
	public LegalPerson findOneBy(@PathVariable("identification") String identification) {
		return personQueryResource.findOneLegalPerson(identification);
	}
}
