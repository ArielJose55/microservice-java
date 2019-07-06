package co.com.ajac.ports;

import coremodel.NaturalPerson;

public interface NaturalPersonRepository {

	Boolean verifyExistence(String identification);
	
	NaturalPerson findOne(String identification);
}
