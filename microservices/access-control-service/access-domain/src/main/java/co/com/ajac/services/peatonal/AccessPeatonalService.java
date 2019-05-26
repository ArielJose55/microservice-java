package co.com.ajac.services.peatonal;


import co.com.ajac.ports.PersonCommunicator;
import co.com.ajac.ports.DeviceCommunicator;
import io.vavr.control.Either;
import io.vavr.control.Option;

public class AccessPeatonalService {

	private final PersonCommunicator personCommunicator;
	
	private final DeviceCommunicator propertyCommunicator;
	
	public AccessPeatonalService(PersonCommunicator personCommunicator, DeviceCommunicator propertyCommunicator) {
		this.personCommunicator = personCommunicator;
		this.propertyCommunicator = propertyCommunicator;
	}

	public Either<String, Option<Integer>> registerAccess(String serial, String code){
		
		Option<Integer> optionCommon = propertyCommunicator.verifyCommonPropertyExistence(serial);
		
		if(!optionCommon.isDefined()) {
			
		}
			return Either.left("Ouup! No se encontro en el sistema algun dispositivo con este serial");
		
		Option<String> optionPersonal = personCommunicator.verifyExistenceBySecurityCode(code);
		
		if(!optionPersonal.isDefined())
			return Either.left("Ouup! Codigo incorrecto");
		
		
				
	}
}
