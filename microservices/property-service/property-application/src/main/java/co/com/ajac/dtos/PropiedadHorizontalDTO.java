package co.com.ajac.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PropiedadHorizontalDTO {
	
	private  String nit;
	private  String numId;
	private  String tipoId;
	private  String nombreDistintivo;
	private  String objetoSocial;
	private  String razonSocial;
	private  List<CommonPropertyDTO> commonProperties;

}
