package co.com.ajac.entities.residentes;


import co.com.ajac.entities.residentes.habitantes.Habitante;
import coremodel.datosbasicos.CorreoElectronico;
import coremodel.datosbasicos.DatoBiometrico;
import coremodel.datosbasicos.Direccion;
import coremodel.datosbasicos.Identificacion;
import coremodel.datosbasicos.NombreCompleto;
import coremodel.datosbasicos.Telefono;
import io.vavr.collection.List;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@RequiredArgsConstructor
public class Residente  {

	private final Identificacion identificacion;
	
	private final Direccion direccion;
	
	private final CorreoElectronico correoElectronico;
	
	private final Telefono telefono;

	private final NombreCompleto nombreCompleto;
	
	private final DatoBiometrico datoBiometrico;
	
	private final List<Habitante> habitantes;
	
	
}
