package co.com.ajac.domain.propiedadeshorizontales.propiedadescomunes.dispositivo;

import co.com.ajac.domain.propiedadeshorizontales.propiedadescomunes.PropiedadComun;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@RequiredArgsConstructor
public class Dispositivo {
	
	private final String serial;
	
	private final String nombre;
	
	private final EstadoDispositivo estadoDispositivo;
	
	private final TipoDispositivo tipoDispositivo;
	
	private final PropiedadComun propiedadComun;
}
