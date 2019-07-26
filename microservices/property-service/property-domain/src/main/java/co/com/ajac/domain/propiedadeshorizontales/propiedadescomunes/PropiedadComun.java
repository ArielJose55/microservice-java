package co.com.ajac.domain.propiedadeshorizontales.propiedadescomunes;

import co.com.ajac.domain.propiedadeshorizontales.PropiedadHorizontal;
import co.com.ajac.domain.propiedadeshorizontales.propiedadescomunes.dispositivo.Dispositivo;
import io.vavr.collection.List;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@RequiredArgsConstructor
public class PropiedadComun {

	private final Integer idPropiedadComun;
	
	private final String nombre;
	
	private final Boolean esencial;
	
	private final PropiedadHorizontal propiedadHorizontal;
	
	private final List<Dispositivo> dispositivos;
}
