package co.com.ajac.database.repositories.acl.builders;

import co.com.ajac.database.repositories.personanatural.PersonaNaturalRecord;
import co.com.ajac.database.repositories.residente.ResidenteRecord;
import co.com.ajac.entities.residentes.Residente;
import coremodel.datosbasicos.DatoBiometrico;
import coremodel.datosbasicos.Identificacion;
import coremodel.datosbasicos.NombreCompleto;

public class ResidenteDatabaseBuilder {

private ResidenteDatabaseBuilder() {}
	
	public static Residente crearResidenteDesdeRecord(ResidenteRecord residenteRecord) {
		Identificacion identificacion = Identificacion.builder()
				.tipoIdentificacion(residenteRecord.getPersonaNaturalRecord().getTipoIdentificacion())
				.numeroIdentificacion(residenteRecord.getPersonaNaturalRecord().getNumeroIdentificacion())
				.build();
		
		DatoBiometrico datoBiometrico = DatoBiometrico.builder()
				.plantilla(residenteRecord.getHuellaPlantilla())
				.codigoDeSeguridad(residenteRecord.getCodigoDeSeguridad())
				.build();
		
		NombreCompleto nombreCompleto = NombreCompleto.builder()
				.primerApellido(residenteRecord.getPersonaNaturalRecord().getPrimerNombre())
				.segundoNombre(residenteRecord.getPersonaNaturalRecord().getSegundoNombre())
				.primerApellido(residenteRecord.getPersonaNaturalRecord().getPrimerApellido())
				.segundoApellido(residenteRecord.getPersonaNaturalRecord().getSegundoApellido())
				.build();
		
		return Residente.builder()
		.identificacion(identificacion)
		.datoBiometrico(datoBiometrico)
		.nombreCompleto(nombreCompleto)
		.build();
	}
	
	public static ResidenteRecord crearResidenteRecordDesdeEntidad(Residente residente) {
		PersonaNaturalRecord personaNaturalRecord = new PersonaNaturalRecord(
				residente.getIdentificacion().getNumeroIdentificacion(),
				residente.getIdentificacion().getTipoIdentificacion(),
				residente.getNombreCompleto().getPrimerNombre(),
				residente.getNombreCompleto().getSegundoNombre(),
				residente.getNombreCompleto().getPrimerApellido(),
				residente.getNombreCompleto().getSegundoApellido());
		
		return new ResidenteRecord(
				personaNaturalRecord,
				residente.getDatoBiometrico().getPlantilla(),
				residente.getDatoBiometrico().getCodigoDeSeguridad(),
				Boolean.TRUE);
	}
}
