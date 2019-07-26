package co.com.ajac.repositories;

import co.com.ajac.domain.propiedadeshorizontales.propiedadesprivadas.PropiedadPrivada;
import io.vavr.collection.List;
import io.vavr.control.Option;

public interface PropiedadPrivadaRepository {

	PropiedadPrivada guardarPropiedadCommun(PropiedadPrivada propiedadPrivada);
	
	Option<PropiedadPrivada> obtenerPropiedadComun(Integer id);
	
	List<PropiedadPrivada> obtenerPropiedadesComunesDeUnaPropiedadHorizontal(String nit);
}
