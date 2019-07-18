package co.com.ajac.acls.builders;

import co.com.ajac.database.repositories.propiedadhorizontal.propiedadhorizontal.PropiedadHorizontalRecord;
import co.com.ajac.domain.phs.Administrador;
import co.com.ajac.domain.phs.PropiedadHorizontal;
import io.vavr.collection.List;

public class PropiedadHorizontalBuider {
	
	private PropiedadHorizontalBuider() {}
	
	public static PropiedadHorizontal convertHorizontalPropertyFromRecord(PropiedadHorizontalRecord propiedadHorizontalRecord) {
		
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
