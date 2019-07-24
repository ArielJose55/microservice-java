package co.com.ajac.services;

import co.com.ajac.ports.AdministradorRepository;

public class AdministradorService {
	
	private static final String PERSONA_JURIDICA_NO_REGISTRADA = "¡Ouups! Lo sentimos esta persona juridica no pudo ser registrada. Intentelo nuevamente";
	private static final String PERSONA_JURIDICA_NO_ENCONTRADA = "¡Ouups! Lo sentimos esta persona juridica no esta registrada en nuestro sistema";
	
	private final AdministradorRepository repository;

	public AdministradorService(AdministradorRepository repository) {
		this.repository = repository;
	}
	
	/*
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
	}*/
}
