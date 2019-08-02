package co.com.ajac.dtos;

import java.util.List;

import coremodel.datosbasicos.Identificacion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PropiedadPrivadaDTO {
	
	private Integer id;
	private String ubicacion;
	private String propiedadHorizontal;
	private List<Identificacion> residentes;
}
