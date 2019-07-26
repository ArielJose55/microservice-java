package co.com.ajac.domain.propiedadeshorizontales.propiedadesprivadas;

import coremodel.datosbasicos.Identificacion;
import io.vavr.collection.List;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@RequiredArgsConstructor
public class PropiedadPrivada {
	
	private final Integer idPropiedadPrivada;
	
	private final String ubicacion;
	
	private final List<Identificacion> residentes;
}
