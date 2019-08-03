package co.com.ajac.database.repositories.acl.builders;

import co.com.ajac.database.repositories.personanatural.PersonaNaturalRecord;
import co.com.ajac.database.repositories.residente.ResidenteRecord;
import co.com.ajac.entities.residentes.habitantes.Habitante;
import coremodel.datosbasicos.DatoBiometrico;
import coremodel.datosbasicos.Identificacion;
import coremodel.datosbasicos.NombreCompleto;

public class HabitanteDatabaseBuilder {

	public static Habitante crearHabitanteDesdeRecord(ResidenteRecord habitanteRecord) {
		
		Identificacion identificacion = Identificacion.builder()
				.tipoIdentificacion(habitanteRecord.getPersonaNaturalRecord().getTipoIdentificacion())
				.numeroIdentificacion(habitanteRecord.getPersonaNaturalRecord().getNumeroIdentificacion())
				.build();
		
		DatoBiometrico datoBiometrico = DatoBiometrico.builder()
				.plantilla(habitanteRecord.getHuellaPlantilla())
				.codigoDeSeguridad(habitanteRecord.getCodigoDeSeguridad())
				.build();
		
		NombreCompleto nombreCompleto = NombreCompleto.builder()
				.primerApellido(habitanteRecord.getPersonaNaturalRecord().getPrimerNombre())
				.segundoNombre(habitanteRecord.getPersonaNaturalRecord().getSegundoNombre())
				.primerApellido(habitanteRecord.getPersonaNaturalRecord().getPrimerApellido())
				.segundoApellido(habitanteRecord.getPersonaNaturalRecord().getSegundoApellido())
				.build();
		
		return Habitante.builder()
		.identificacion(identificacion)
		.datoBiometrico(datoBiometrico)
		.nombreCompleto(nombreCompleto)
		.build();
	}
	
	public static ResidenteRecord crearHabitanteRecordDesdeEntidad(Habitante habitante) {
		
		PersonaNaturalRecord personaNaturalRecord = new PersonaNaturalRecord(
				habitante.getIdentificacion().getNumeroIdentificacion(),
				habitante.getIdentificacion().getTipoIdentificacion(),
				habitante.getNombreCompleto().getPrimerNombre(),
				habitante.getNombreCompleto().getSegundoNombre(),
				habitante.getNombreCompleto().getPrimerApellido(),
				habitante.getNombreCompleto().getSegundoApellido());
		
		return new ResidenteRecord(
				personaNaturalRecord,
				habitante.getDatoBiometrico().getPlantilla(),
				habitante.getDatoBiometrico().getCodigoDeSeguridad(),
				Boolean.FALSE);
	}
}
