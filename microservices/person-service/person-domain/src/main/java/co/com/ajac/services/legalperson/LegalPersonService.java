package co.com.ajac.services.legalperson;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Patterns.$None;
import static io.vavr.Patterns.$Some;

import co.com.ajac.ports.LegalPersonRepository;
import coremodel.LegalPerson;
import io.vavr.control.Either;
import io.vavr.control.Option;

public class LegalPersonService {
	
	private static final String PERSONA_JURIDICA_NO_REGISTRADA = "¡Ouups! Lo sentimos esta persona juridica no pudo ser registrada. Intentelo nuevamente";
	private static final String PERSONA_JURIDICA_NO_ENCONTRADA = "¡Ouups! Lo sentimos esta persona juridica no esta registrada en nuestro sistema";
	
	private final LegalPersonRepository repository;

	public LegalPersonService(LegalPersonRepository repository) {
		this.repository = repository;
	}
	
	public Either<String, Integer> registerLegarPerson(LegalPerson legalDataPerson){
		Option<Integer> optionLegalPerson = repository.registerLegalPerson(legalDataPerson);
		return Match(optionLegalPerson).of(
				Case($Some($()), Either::right),
				Case($None(), Either.left(PERSONA_JURIDICA_NO_REGISTRADA))
				);
	}
	
	public Either<String, LegalPerson> findOneLegalPerson(String identification){
		Option<LegalPerson> optionLegalPerson = repository.findLegalPersonBy(identification);
		return Match(optionLegalPerson).of(
				Case($Some($()), Either::right),
				Case($None(), Either.left(PERSONA_JURIDICA_NO_ENCONTRADA))
				);
	}
}
