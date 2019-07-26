package co.com.ajac.domain.propiedadeshorizontales;

import co.com.ajac.domain.propiedadeshorizontales.propiedadescomunes.PropiedadComun;
import co.com.ajac.domain.propiedadeshorizontales.propiedadesprivadas.PropiedadPrivada;
import io.vavr.collection.List;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@RequiredArgsConstructor
@ToString
public class PropiedadHorizontal {
	
	private final String nit;
	
	private final String nombreDistintivo;
	
	private final Administrador administrador;
	
	private final List<PropiedadComun> bienesCommunes;
	
	private final List<PropiedadPrivada> bienesPrivados;

}
