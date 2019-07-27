package co.com.ajac.dtos;

import coremodel.datosbasicos.CorreoElectronico;
import coremodel.datosbasicos.Direccion;
import coremodel.datosbasicos.Telefono;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaJuridicaDTO {

	private String nit;
	private String razonSocial;
	private String objetoSocial;
	private Direccion direccion;	
	private CorreoElectronico correoElectronico;
	private Telefono telefono;
}
