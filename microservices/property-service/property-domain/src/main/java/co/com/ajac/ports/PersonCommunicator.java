package co.com.ajac.ports;

import coremodel.LegalPerson;
import io.vavr.control.Option;

public interface PersonCommunicator {

	Option<String> registerLegalPerson(LegalPerson property);
	
	Option<String> getIdProperty(String identification, String type);
}
