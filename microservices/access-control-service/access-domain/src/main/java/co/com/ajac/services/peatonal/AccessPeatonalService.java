package co.com.ajac.services.peatonal;


import co.com.ajac.ports.PersonCommunicator;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Patterns.$None;
import static io.vavr.Patterns.$Some;

import co.com.ajac.ports.DeviceCommunicator;
import io.vavr.control.Either;
import io.vavr.control.Option;

public class AccessPeatonalService {

	private final PersonCommunicator personCommunicator;
	
	private final DeviceCommunicator deviceCommunicator;
	
	public AccessPeatonalService(PersonCommunicator personCommunicator, DeviceCommunicator deviceCommunicator) {
		this.personCommunicator = personCommunicator;
		this.deviceCommunicator = deviceCommunicator;
	}

	public Either<String, Option<Integer>> registerAccess(String serial, String identification){
		
		Option<Integer> optionCommon = deviceCommunicator.verifyDeviceExistence(serial);
		
		if(!optionCommon.isDefined()) 
			return Either.left("Ouup! No se encontro en el sistema algun dispositivo con este serial");
		
			
		Option<String> optionPersonal = personCommunicator.verifyExistenceBySecurityCode(identification);
		
		if(!optionPersonal.isDefined())
			return Either.left("Ouup! Codigo incorrecto");
		
		Option<String> verifySanctionAtPerson = personCommunicator.verifySanctionAtPerson(identification);
		
		if(verifySanctionAtPerson.isDefined())
			return Either.left("La persona con esta identification no puede hacer uso de esta area comun, por disposicion del administrador");
		
		
		Option<String> reservationActiveNow = personCommunicator.verifyReservationActiveNow(identification);
		
		return Match(reservationActiveNow).of(
				Case($Some($()), person -> {
					
				}),
				Case($None(), rese)
				);
		
		// Se debe limitar el acceso a residente o habitante cuando alguna reserva este activa.
		
	}
}
