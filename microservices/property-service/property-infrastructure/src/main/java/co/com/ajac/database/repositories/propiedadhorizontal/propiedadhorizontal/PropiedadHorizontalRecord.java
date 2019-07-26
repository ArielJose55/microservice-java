package co.com.ajac.database.repositories.propiedadhorizontal.propiedadhorizontal;

import co.com.ajac.database.repositories.propiedadcomun.PropiedadComunRecord;
import co.com.ajac.database.repositories.propiedadhorizontal.administrador.AdministradorRecord;
import co.com.ajac.database.repositories.propiedadprivada.PropiedadPrivadaRecord;
import io.vavr.collection.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class PropiedadHorizontalRecord {
	private final String nit;
	private final String nombreDistintivo;
	private final AdministradorRecord administrador;
	private final List<PropiedadComunRecord> commonsProperties;
	private final List<PropiedadPrivadaRecord> privatesProperties;

}
