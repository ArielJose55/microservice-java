package co.com.ajac.repositories;

import co.com.ajac.domain.propiedadeshorizontales.propiedadescomunes.PropiedadComun;
import io.vavr.collection.List;
import io.vavr.control.Option;

public interface PropiedadComunRepository {

	PropiedadComun guardarPropiedadCommun(PropiedadComun propiedadComun);
	
	Option<PropiedadComun> obtenerPropiedadComun(Integer id);
	
	List<PropiedadComun> obtenerPropiedadesComunesDeUnaPropiedadHorizontal(String nit);
}
