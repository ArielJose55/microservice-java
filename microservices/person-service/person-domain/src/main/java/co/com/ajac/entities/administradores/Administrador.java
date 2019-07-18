package co.com.ajac.entities.administradores;

import coremodel.persona.datosbasicos.CorreoElectronico;
import coremodel.persona.datosbasicos.Direccion;
import coremodel.persona.datosbasicos.NombreCompleto;
import coremodel.persona.datosbasicos.Telefono;
import coremodel.persona.personanatural.DatoBiometrico;
import coremodel.persona.personanatural.Identificacion;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Administrador {

	private final Identificacion identificacion;
	
	private final Direccion direccion;
	
	private final CorreoElectronico correoElectronico;
	
	private final Telefono telefono;

	private final NombreCompleto nombreCompleto;
	
	private final DatoBiometrico datoBiometrico;
	
	private final TipoAdministrador typeAdministrator;	
}
