package co.com.ajac.database.repositories.builders.propiedadprivada;

import co.com.ajac.database.repositories.builders.propiedadhotizontal.PropiedadHorizontalDatabaseBuilder;
import co.com.ajac.database.repositories.propiedadprivada.PropiedadPrivadaRecord;
import co.com.ajac.domain.propiedadeshorizontales.propiedadesprivadas.PropiedadPrivada;
import io.vavr.collection.List;

public class PropiedadPrivadaDatabaseBuilder {

	private PropiedadPrivadaDatabaseBuilder() {
	}

	public static PropiedadPrivadaRecord crearPropiedadPrivadaRecordDesdeEntidad(PropiedadPrivada propiedadPrivada) {
		return new PropiedadPrivadaRecord(
				propiedadPrivada.getIdPropiedadPrivada(),
				propiedadPrivada.getUbicacion(),
				PropiedadHorizontalDatabaseBuilder
						.crearPropiedadHorizontalRecordDesdeEntidad(propiedadPrivada.getPropiedadHorizontal()));
	}

	public static PropiedadPrivada crearPropiedadPrivadaDesdeRecord(PropiedadPrivadaRecord propiedadPrivadaRecord) {
		return PropiedadPrivada.builder().idPropiedadPrivada(propiedadPrivadaRecord.getId())
				.ubicacion(propiedadPrivadaRecord.getUbicacion()).residentes(List.empty()).build();
	}
}
