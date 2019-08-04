package co.com.ajac.acl.builders;

import co.com.ajac.dtos.DatoBiometricoDTO;
import co.com.ajac.dtos.ResidenteDTO;
import co.com.ajac.entities.residentes.Residente;
import coremodel.datosbasicos.DatoBiometrico;
import coremodel.datosbasicos.Identificacion;
import coremodel.datosbasicos.NombreCompleto;

public class ResidenteBuilder {

	private ResidenteBuilder() {}
	
	public static Residente crearResidenteDesdeRequest(ResidenteDTO residenteDTO) {
		
		Identificacion identificacion = Identificacion.builder()
				.numeroIdentificacion(residenteDTO.getNumIdResidente())
				.tipoIdentificacion(residenteDTO.getTipoIdResidente())
				.build();
		
		NombreCompleto nombreCompleto = NombreCompleto.builder()
				.primerNombre(residenteDTO.getPrimerNombre())
				.segundoNombre(residenteDTO.getSegundoNombre())
				.primerApellido(residenteDTO.getPrimerApellido())
				.segundoApellido(residenteDTO.getSegundoApellido())
				.build();
		
		DatoBiometrico datoBiometrico = DatoBiometrico.builder()
				.plantilla(residenteDTO.getDatoBiometrico().getHuellaDigital())
				.codigoDeSeguridad(residenteDTO.getDatoBiometrico().getCodigoDeSeguridad())
				.build();
		
		
		return Residente.builder()
				.identificacion(identificacion)
				.nombreCompleto(nombreCompleto)
				.datoBiometrico(datoBiometrico)
				.build();
	}
	
	public static ResidenteDTO crearResidenteDTODesdeEntidad(Residente residente) {
		return ResidenteDTO.builder()
				.numIdResidente(residente.getIdentificacion().getNumeroIdentificacion())
				.tipoIdResidente(residente.getIdentificacion().getTipoIdentificacion())
				.primerNombre(residente.getNombreCompleto().getPrimerNombre())
				.segundoNombre(residente.getNombreCompleto().getSegundoNombre())
				.primerApellido(residente.getNombreCompleto().getPrimerApellido())
				.segundoApellido(residente.getNombreCompleto().getSegundoApellido())
				.nombreCompleto(residente.getNombreCompleto().nombreCompleto())
				.datoBiometrico(DatoBiometricoDTO.builder()
						.huellaDigital(residente.getDatoBiometrico().getPlantilla())
						.codigoDeSeguridad(residente.getDatoBiometrico().getCodigoDeSeguridad())
						.build())
				.build();
	}
}
