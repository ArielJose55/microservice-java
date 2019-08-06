package coremodel.datosbasicos;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@RequiredArgsConstructor
public class Vehiculo {
	private final String matricula;
	private final String modelo;
}
