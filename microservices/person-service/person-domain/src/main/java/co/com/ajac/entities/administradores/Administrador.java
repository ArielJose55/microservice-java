package co.com.ajac.entities.administradores;

import coremodel.datosbasicos.CorreoElectronico;
import coremodel.datosbasicos.DatoBiometrico;
import coremodel.datosbasicos.Direccion;
import coremodel.datosbasicos.Identificacion;
import coremodel.datosbasicos.NombreCompleto;
import coremodel.datosbasicos.Telefono;
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
