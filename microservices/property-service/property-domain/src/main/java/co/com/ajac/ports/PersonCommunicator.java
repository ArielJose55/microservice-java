package co.com.ajac.ports;

import coremodel.LegalPerson;
import io.vavr.control.Option;

public interface PersonCommunicator {

	Option<Integer> registerLegalPerson(LegalPerson property);
	
	Option<Integer> getIdProperty(String identification, String type);
}
