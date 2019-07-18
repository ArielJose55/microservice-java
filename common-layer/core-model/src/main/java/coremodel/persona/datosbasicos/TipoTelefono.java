package coremodel.persona.datosbasicos;

import java.util.Arrays;

import coremodel.excepciones.BusinessException;

public enum TipoTelefono {
	MOVIL("Celular"),
	FIJO("Fijo");
	
	private final String descripcion;

	private TipoTelefono(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public static TipoTelefono getTipoTelefonoDesdeDescripcion(String description) {
		return Arrays.asList(TipoTelefono.values())
			.stream()
			.filter(type -> description != null && description.compareTo("") != 0 && description.equalsIgnoreCase(type.getDescripcion()))
			.findFirst()
			.orElseThrow(() -> new BusinessException("No exite ningun tipo de telefono con esta descripcion"));
	}
	
}