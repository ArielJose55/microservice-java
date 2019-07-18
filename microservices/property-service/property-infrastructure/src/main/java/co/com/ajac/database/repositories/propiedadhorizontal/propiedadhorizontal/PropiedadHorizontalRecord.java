package co.com.ajac.database.repositories.propiedadhorizontal.propiedadhorizontal;

import co.com.ajac.database.repositories.commonsproperty.CommonPropertyRecord;
import co.com.ajac.database.repositories.privatesproperty.PrivatePropertyRecord;
import co.com.ajac.database.repositories.propiedadhorizontal.administrador.AdministradorRecord;
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
	private final List<CommonPropertyRecord> commonsProperties;
	private final List<PrivatePropertyRecord> privatesProperties;

}
