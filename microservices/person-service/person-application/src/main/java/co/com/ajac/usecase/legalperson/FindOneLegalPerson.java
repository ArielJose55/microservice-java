package co.com.ajac.usecase.legalperson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.models.LegalDataPerson;
import co.com.ajac.services.legalperson.LegalPersonService;
import common.Query;
import domain.exceptions.ModelNotFoundException;
import io.vavr.control.Either;

@Component
public class FindOneLegalPerson implements Query<LegalDataPerson, String>{

	private final LegalPersonService service;

	@Autowired
	public FindOneLegalPerson(LegalPersonService service) {
		this.service = service;
	}

	@Override
	public LegalDataPerson execute(String identification) {
		Either<String, LegalDataPerson> findOne = service.findOneLegalPerson(identification);
		return findOne.getOrElseThrow(
				() -> new ModelNotFoundException(findOne.getLeft())
				);
	}
	
	
}
