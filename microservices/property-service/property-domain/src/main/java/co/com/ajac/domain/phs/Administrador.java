package co.com.ajac.domain.phs;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@RequiredArgsConstructor
public class Administrador {

	private final String tipoIdentificacion;
	
	private final String numeroIdentificacion;
	
}
