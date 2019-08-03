package co.com.ajac.acl.builders;

import co.com.ajac.dtos.DatoBiometricoDTO;
import co.com.ajac.dtos.HabitanteDTO;
import co.com.ajac.entities.residentes.habitantes.Habitante;
import coremodel.datosbasicos.DatoBiometrico;
import coremodel.datosbasicos.Identificacion;
import coremodel.datosbasicos.NombreCompleto;

public class HabitanteBuilder {
	
private HabitanteBuilder() {}
	
	public static Habitante crearHabitanteDesdeRequest(HabitanteDTO habitanteDTO) {
		
		Identificacion identificacion = Identificacion.builder()
				.numeroIdentificacion(habitanteDTO.getTipoIdHabitante())
				.tipoIdentificacion(habitanteDTO.getNumIdHabitante())
				.build();
		
		NombreCompleto nombreCompleto = NombreCompleto.builder()
				.primerApellido(habitanteDTO.getPrimerNombre())
				.segundoNombre(habitanteDTO.getSegundoNombre())
				.primerApellido(habitanteDTO.getPrimerApellido())
				.segundoApellido(habitanteDTO.getSegundoApellido())
				.build();
		
		DatoBiometrico datoBiometrico = DatoBiometrico.builder()
				.plantilla(habitanteDTO.getDatoBiometrico().getHuellaDigital())
				.codigoDeSeguridad(habitanteDTO.getDatoBiometrico().getCodigoDeSeguridad())
				.build();
		
		return Habitante.builder()
		.identificacion(identificacion)
		.nombreCompleto(nombreCompleto)
		.datoBiometrico(datoBiometrico)
		.build();
	}
	
	public static HabitanteDTO crearHabitanteDTODesdeEntidad(Habitante habitante) {
		return HabitanteDTO.builder()
		.numIdHabitante(habitante.getIdentificacion().getNumeroIdentificacion())
		.tipoIdHabitante(habitante.getIdentificacion().getTipoIdentificacion())
		.primerNombre(habitante.getNombreCompleto().getPrimerNombre())
		.segundoNombre(habitante.getNombreCompleto().getSegundoNombre())
		.primerApellido(habitante.getNombreCompleto().getPrimerApellido())
		.segundoApellido(habitante.getNombreCompleto().getSegundoApellido())
		.nombreCompleto(habitante.getNombreCompleto().nombreCompleto())
		.datoBiometrico(DatoBiometricoDTO.builder()
				.huellaDigital(habitante.getDatoBiometrico().getPlantilla())
				.codigoDeSeguridad(habitante.getDatoBiometrico().getCodigoDeSeguridad())
				.build())
		.build();
	}

}
