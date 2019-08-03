package co.com.ajac.database.repositories.residente;

import co.com.ajac.database.repositories.personanatural.PersonaNaturalRecord;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ResidenteRecord {
	
	private final PersonaNaturalRecord personaNaturalRecord;
	private final String huellaPlantilla;
	private final String codigoDeSeguridad;
	private final Boolean esTitular;
}
