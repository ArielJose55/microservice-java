package co.com.ajac.database.repositories.propiedadprivada;

import co.com.ajac.database.repositories.propiedadhorizontal.propiedadhorizontal.PropiedadHorizontalRecord;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PropiedadPrivadaRecord {

	private final Integer id;
	private final String ubicacion;
	private final PropiedadHorizontalRecord propiedadHorizontalRecord;
}
