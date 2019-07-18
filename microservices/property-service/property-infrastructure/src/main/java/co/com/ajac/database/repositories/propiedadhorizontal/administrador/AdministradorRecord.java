package co.com.ajac.database.repositories.propiedadhorizontal.administrador;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AdministradorRecord {
	
	private final String nit;
	private final String numeroId;
	private final String tipoId;
	private final Timestamp fechaAsignacion;

}
