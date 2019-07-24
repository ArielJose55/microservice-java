package co.com.ajac.acl.propiedadhorizontal.modelos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropiedadHorizontalDTO {

	private String nit;
	private String numId;
	private String tipoId;
	private String nombreDistintivo;
	private String objetoSocial;
	private String razonSocial;
}
