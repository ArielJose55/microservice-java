package co.com.ajac.database.repositories.propiedadcomun;

import co.com.ajac.database.repositories.propiedadhorizontal.propiedadhorizontal.PropiedadHorizontalRecord;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PropiedadComunRecord {
	
	private final Integer id;
	private final String nombre;
	private final Boolean esencial;
	private final PropiedadHorizontalRecord propiedadHorizontalRecord;
}
