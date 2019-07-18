package coremodel.persona.personajuridica;

import coremodel.persona.datosbasicos.CorreoElectronico;
import coremodel.persona.datosbasicos.Direccion;
import coremodel.persona.datosbasicos.Telefono;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class PersonaJuridica  {
	
	protected final String nit;
	
	protected final Direccion direccion;
	
	protected final CorreoElectronico correoElectronico;
	
	protected final Telefono telefono;
	
	protected final String razonSocial;
		
	protected final String objetoSocial;
	
}
