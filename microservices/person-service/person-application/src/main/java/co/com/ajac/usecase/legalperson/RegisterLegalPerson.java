package co.com.ajac.usecase.legalperson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.Command;
import domain.exceptions.NotSaveModelException;
import co.com.ajac.models.LegalDataPerson;
import co.com.ajac.services.legalperson.LegalPersonService;
import io.vavr.control.Either;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class RegisterLegalPerson implements Command<Integer, LegalDataPerson>{

	private final LegalPersonService service;

	@Autowired
	public RegisterLegalPerson(LegalPersonService service) {
		this.service = service;
	}

	@Override
	public Integer excute(LegalDataPerson command) {
		log.debug("ejecutando el comando de registrar person {0} ", command);
		
		Either<String, Integer> eitherResult = service.registerLegarPerson(command);
		return eitherResult.getOrElseThrow(() -> new NotSaveModelException(eitherResult.getLeft()));
	}
}
