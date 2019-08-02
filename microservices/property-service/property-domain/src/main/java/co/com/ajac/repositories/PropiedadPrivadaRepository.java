package co.com.ajac.repositories;

import co.com.ajac.domain.propiedadeshorizontales.propiedadesprivadas.PropiedadPrivada;
import io.vavr.collection.List;
import io.vavr.control.Option;

public interface PropiedadPrivadaRepository {

	PropiedadPrivada guardarPropiedadPrivada(PropiedadPrivada propiedadPrivada);
	
	Option<PropiedadPrivada> obtenerPropiedadPrivada(Integer id);
	
	List<PropiedadPrivada> obtenerPropiedadesPrivadasDeUnaPropiedadHorizontal(String nit);
}
