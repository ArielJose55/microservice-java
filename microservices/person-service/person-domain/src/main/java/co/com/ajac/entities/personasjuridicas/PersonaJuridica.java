package co.com.ajac.entities.personasjuridicas;

import coremodel.datosbasicos.CorreoElectronico;
import coremodel.datosbasicos.Direccion;
import coremodel.datosbasicos.Telefono;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@RequiredArgsConstructor
public class PersonaJuridica  {
	
	protected final String nit;
	
	protected final Direccion direccion;
	
	protected final CorreoElectronico correoElectronico;
	
	protected final Telefono telefono;
	
	protected final String razonSocial;
		
	protected final String objetoSocial;
	
}

