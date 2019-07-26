package co.com.ajac.database.repositories.builders.propiedadhotizontal;

import co.com.ajac.database.repositories.propiedadhorizontal.administrador.AdministradorRecord;
import co.com.ajac.database.repositories.propiedadhorizontal.propiedadhorizontal.PropiedadHorizontalRecord;
import co.com.ajac.domain.propiedadeshorizontales.Administrador;
import co.com.ajac.domain.propiedadeshorizontales.PropiedadHorizontal;
import io.vavr.collection.List;

public class PropiedadHorizontalDatabaseBuilder {

	public static PropiedadHorizontal crearPropiedadHorizontalDesdeRecord(PropiedadHorizontalRecord propiedadHorizontalRecord) {
		return PropiedadHorizontal.builder()
			.nit(propiedadHorizontalRecord.getNit())
			.administrador(Administrador.builder()
					.tipoIdentificacion(propiedadHorizontalRecord.getAdministrador().getTipoId())
					.numeroIdentificacion(propiedadHorizontalRecord.getAdministrador().getNumeroId())
					.build())					
			.nombreDistintivo(propiedadHorizontalRecord.getNombreDistintivo())
			.bienesCommunes(List.empty())
			.bienesPrivados(List.empty())
			.build();
	}
	
	public static PropiedadHorizontalRecord crearPropiedadHorizontalRecordDesdeEntidad(PropiedadHorizontal propiedadHorizontal) {
		
		AdministradorRecord administradorRecord = new AdministradorRecord(
				propiedadHorizontal.getNit(),
				propiedadHorizontal.getAdministrador().getNumeroIdentificacion(),
				propiedadHorizontal.getAdministrador().getTipoIdentificacion(),
				null);
		
		return new PropiedadHorizontalRecord(
				propiedadHorizontal.getNit(),
				propiedadHorizontal.getNombreDistintivo(),
				administradorRecord,
				List.empty(),
				List.empty());
	}
}
