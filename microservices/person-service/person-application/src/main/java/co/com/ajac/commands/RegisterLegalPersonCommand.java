package co.com.ajac.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.services.legalperson.LegalPersonService;
import common.Command;
import coremodel.LegalPerson;
import domain.exceptions.NotSaveModelException;
import io.vavr.control.Either;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class RegisterLegalPersonCommand implements Command<LegalPerson> {

	private final LegalPersonService service;

	@Autowired
	public RegisterLegalPersonCommand(LegalPersonService service) {
		this.service = service;
	}

	@Override
	public void execute(LegalPerson command) {
		log.debug("ejecutando el comando de registrar person {0} ", command);

		Either<String, Integer> eitherResult = service.registerLegarPerson(command);
		eitherResult.getOrElseThrow(() -> new NotSaveModelException(eitherResult.getLeft()));

	}
}
