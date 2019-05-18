package co.com.ajac.ports;

import co.com.ajac.models.LegalDataPerson;
import io.vavr.control.Option;

public interface LegalPersonRepository {
	Option<Integer> registerLegalPerson(LegalDataPerson legalPerson);
	Option<LegalDataPerson> findLegalPersonBy(String identification);
}
