package co.com.ajac.repositories;

import co.com.ajac.domain.propiedadeshorizontales.Administrador;
import co.com.ajac.domain.propiedadeshorizontales.PropiedadHorizontal;
import io.vavr.collection.List;
import io.vavr.control.Option;

public interface PropiedadHorizontalRepository {

	PropiedadHorizontal registrarPropiedadHorizontal(PropiedadHorizontal horizontalProperty);
	
	Option<PropiedadHorizontal> obtenerPropiedadHorizontalPorNit(String nit);
	
	List<PropiedadHorizontal> obtenerTodasPropiedadesHorizontalesPorAdministrador(Administrador administrador);

}
