package co.com.ajac.entities.usuarios;

import co.com.ajac.domain.exceptions.TechnicalException;
import io.vavr.collection.List;

public enum TipoUsuario {
	
	ADMINISTRADOR("Administrador", "ADMIN"),
	RESIDENTE("Residente", "RESIDENTE"),
	AUXILIAR("Auxiliar", "AUXILIAR"),
	PORTERO("Portero de seguridad", "SEGURIDAD");
	
	private final String descripcion;
	private final String codigo;

	TipoUsuario(String descripcion, String codigo) {
		this.descripcion = descripcion;
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public static TipoUsuario obtenerTipoUsuarioDesdeCodigo(String codigo) {
		return List.of(TipoUsuario.values())
			.filter(tipoUsuario -> codigo != null && codigo.compareTo("") != 0 && tipoUsuario.getCodigo().equalsIgnoreCase(codigo))
			.getOrElseThrow(() -> new TechnicalException(
					"Este codigo: "+codigo+" no pertenece a nungin Tipo de usuario valido"));
	}
}
