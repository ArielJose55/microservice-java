package co.com.ajac.entities.residentes.reservas;

import io.vavr.collection.List;

public enum EstadoReserva {
	APROVADA("OK"),
	RECHAZADA("FAIL"),
	TRAMITE("TRA");
	
	private final String codigo;

	EstadoReserva(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public static EstadoReserva getEstadoReservaDesdeCodigo(String codigo) {
		return List.of(EstadoReserva.values())
			.filter(estado -> codigo != null && codigo.compareTo("") != 0 && estado.getCodigo().equalsIgnoreCase(codigo))
			.getOrElseThrow(() -> new EnumConstantNotPresentException(EstadoReserva.class,
					"Este codigo " + codigo + " no corresponde a ningun estado de reserva"));
	}
	
}
