package co.com.ajac.entities.usuarios;

import java.time.LocalDateTime;

import coremodel.datosbasicos.Identificacion;
import coremodel.datosbasicos.NombreCompleto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@RequiredArgsConstructor
public class Usuario {
	
	private final Identificacion identificacion;
	
	private final NombreCompleto nombreCompleto;

	private final Credencial credencial;
	
	private final LocalDateTime fechaRegistro;

	private final TipoUsuario tipoUsuario;
	
	private final EstadoUsuario estadoUsuario;
	
	private final LocalDateTime fechaFinalizacion;
	
}