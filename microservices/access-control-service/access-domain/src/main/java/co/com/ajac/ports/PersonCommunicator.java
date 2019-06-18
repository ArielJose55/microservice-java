package co.com.ajac.ports;

import io.vavr.control.Option;

public interface PersonCommunicator {

	Option<String> verifyExistenceByFingerPrint(String fingerPrint);
	
	Option<String> verifyExistenceBySecurityCode(String code);
	
	Option<String> verifyReservationActiveNow(String identification);
	
	Option<String> verifySanctionAtPerson(String identification);
}
