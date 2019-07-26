package co.com.ajac.acls.builders;

import co.com.ajac.database.repositories.propiedadhorizontal.propiedadhorizontal.PropiedadHorizontalRecord;
import co.com.ajac.domain.propiedadeshorizontales.Administrador;
import co.com.ajac.domain.propiedadeshorizontales.PropiedadHorizontal;
import io.vavr.collection.List;

public class PropiedadHorizontalBuider {
	
	private PropiedadHorizontalBuider() {}
	
	public static PropiedadHorizontal crearPropiedadHorizontalDesdeRecord(PropiedadHorizontalRecord propiedadHorizontalRecord) {
		
		Administrador administrador = new Administrador(
				propiedadHorizontalRecord.getAdministrador().getTipoId(),
				propiedadHorizontalRecord.getAdministrador().getNumeroId());
		
		return PropiedadHorizontal.builder()
				.nit(propiedadHorizontalRecord.getNit())
				.administrador(administrador)
				.nombreDistintivo(propiedadHorizontalRecord.getNombreDistintivo())
				.bienesCommunes(List.empty())
				.bienesPrivados(List.empty())
				.build();
	}

}
