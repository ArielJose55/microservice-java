package co.com.ajac.dtos;

import java.util.List;

import co.com.ajac.domain.propiedadeshorizontales.propiedadescomunes.dispositivo.Dispositivo;
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
public class PropiedadComunDTO {
	
		private Integer id;
		private String nombre;
		private Boolean esencial;
		private String propiedadHorizontal;
		private List<Dispositivo> dispositivos;
		
}
