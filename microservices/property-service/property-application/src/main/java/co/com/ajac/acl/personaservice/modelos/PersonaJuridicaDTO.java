package co.com.ajac.acl.personaservice.modelos;

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
	private String objetoSocial;;
	
}
