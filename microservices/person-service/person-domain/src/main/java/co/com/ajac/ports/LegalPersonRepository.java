package co.com.ajac.ports;

import coremodel.LegalPerson;
import io.vavr.control.Option;

public interface LegalPersonRepository {
	Option<Integer> registerLegalPerson(LegalPerson legalPerson);
	Option<LegalPerson> findLegalPersonBy(String identification);
}
