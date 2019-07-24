package co.com.ajac.entities.usuarios;

import io.vavr.collection.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public enum EstadoUsuario {

	ACTIVO("Activo","AC"),
	INACTIVO("Inactivo","AN");
	
	private final String descripcion;
	private final String codigo;
	
	public static EstadoUsuario obtenerEstadoUsuarioDesdeCodigo(String codigo) {
		return List.of(EstadoUsuario.values())
			.filter(estadoUsuario -> codigo != null && codigo.compareTo("") != 0 && estadoUsuario.getCodigo().equalsIgnoreCase(codigo))
			.getOrElseThrow(() -> new EnumConstantNotPresentException(
					EstadoUsuario.class, "El codigo proporcionado: "+codigo +" no pertenece a ningun estado de usuario"));
	}
		
}
