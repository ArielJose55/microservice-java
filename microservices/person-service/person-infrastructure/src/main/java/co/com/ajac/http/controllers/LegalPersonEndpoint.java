package co.com.ajac.http.controllers;

import javax.validation.Valid;

import org.checkerframework.common.reflection.qual.GetConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.infix.lang.infix.antlr.EventFilterParser.filter_return;

import co.com.ajac.models.LegalDataPerson;
import co.com.ajac.usecase.legalperson.FindOneLegalPerson;
import co.com.ajac.usecase.legalperson.RegisterLegalPerson;

@RestController
@RequestMapping("/legalperson")
public class LegalPersonEndpoint {
	
	private final RegisterLegalPerson reLegalPerson;
	private final FindOneLegalPerson findOneLegalPerson;

	@Autowired
	public LegalPersonEndpoint(RegisterLegalPerson reLegalPerson, FindOneLegalPerson findOneLegalPerson) {
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
