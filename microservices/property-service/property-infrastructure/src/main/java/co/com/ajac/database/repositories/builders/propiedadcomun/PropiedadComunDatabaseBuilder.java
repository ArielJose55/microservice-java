package co.com.ajac.database.repositories.builders.propiedadcomun;

import co.com.ajac.database.repositories.builders.propiedadhotizontal.PropiedadHorizontalDatabaseBuilder;
import co.com.ajac.database.repositories.propiedadcomun.PropiedadComunRecord;
import co.com.ajac.domain.propiedadeshorizontales.propiedadescomunes.PropiedadComun;
import io.vavr.collection.List;

public class PropiedadComunDatabaseBuilder {

	private PropiedadComunDatabaseBuilder() {}
	
	public static PropiedadComunRecord crearPropiedadComunRecordDesdeEntidad(PropiedadComun propiedadComun) {
		
		return new PropiedadComunRecord(
				propiedadComun.getIdPropiedadComun(),
				propiedadComun.getNombre(),
				propiedadComun.getEsencial(),
				PropiedadHorizontalDatabaseBuilder.
					crearPropiedadHorizontalRecordDesdeEntidad(propiedadComun.getPropiedadHorizontal()));
	}
	
public static PropiedadComun crearPropiedadComunDesdeRecord(PropiedadComunRecord propiedadComunRecord) {
		
		return PropiedadComun.builder()
				.idPropiedadComun(propiedadComunRecord.getId())
				.nombre(propiedadComunRecord.getNombre())
				.esencial(propiedadComunRecord.getEsencial())
				.dispositivos(List.empty())
				.build();
	}
}
