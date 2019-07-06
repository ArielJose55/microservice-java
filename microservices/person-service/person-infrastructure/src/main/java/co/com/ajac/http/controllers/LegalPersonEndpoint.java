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
import co.com.ajac.models.LegalDataPerson;
import co.com.ajac.usecase.legalperson.FindOneLegalPerson;

@RestController
@RequestMapping("/legalperson")
public class LegalPersonEndpoint {
	
	private final RegisterLegalPersonCommand reLegalPerson;
	private final FindOneLegalPerson findOneLegalPerson;

	@Autowired
	public LegalPersonEndpoint(RegisterLegalPersonCommand reLegalPerson, FindOneLegalPerson findOneLegalPerson) {
		this.findOneLegalPerson = findOneLegalPerson;
		this.reLegalPerson = reLegalPerson;
	}
	
	@PostMapping
	public Integer registerLegalPerson(@Valid @RequestBody LegalDataPerson legalDataPerson) {
		return reLegalPerson.excute(legalDataPerson);
	}
	
	@GetMapping("/{identification}")
	public LegalDataPerson findOneBy(@PathVariable("identification") String identification) {
		return findOneLegalPerson.execute(identification);
	}
}
