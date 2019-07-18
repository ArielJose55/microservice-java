package co.com.ajac.entities.usuarios;

import io.vavr.collection.List;

public enum TipoUsuario {
	
	ADMINISTRADOR("Administrador", "ADM"),
	RESIDENTE("Residente", "RDT"),
	AUXILIAR("Auxiliar", "AUX");
	
	private final String codigo;
	private final String descripcion;


	TipoUsuario(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public static TipoUsuario obtenerTipoUsuarioDesdeCodigo(String codigo) {
		return List.of(TipoUsuario.values())
			.filter(tipoUsuario -> codigo != null && codigo.compareTo("") != 0 && tipoUsuario.getCodigo().equalsIgnoreCase(codigo))
			.getOrElseThrow(() -> new EnumConstantNotPresentException(TipoUsuario.class,
					"Este codigo: "+codigo+" no pertenece a nungin Tipo de usuario valido"));
	}
}
