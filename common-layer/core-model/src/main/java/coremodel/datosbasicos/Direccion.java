package coremodel.datosbasicos;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Direccion {
	private final String pais;
	private final String estado;
	private final String ciudad;
	private final String direccion;
	private final String descripcionAdicional;
}
