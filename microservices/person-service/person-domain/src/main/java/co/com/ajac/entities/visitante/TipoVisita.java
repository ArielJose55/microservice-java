package co.com.ajac.entities.visitante;

public enum TipoVisita {
	FAMILIAR("Familiar", "FML"),
	COMERCIAL("Comercial", "COM"),
	TECNICA("Técnica", "TEC");
	
	private final String descripcion;
	private final String codigo;
	
	TipoVisita(String descripcion, String codigo) {
		this.descripcion = descripcion;
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
