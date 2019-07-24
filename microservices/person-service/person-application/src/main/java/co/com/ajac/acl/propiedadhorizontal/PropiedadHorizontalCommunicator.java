package co.com.ajac.acl.propiedadhorizontal;

import co.com.ajac.acl.propiedadhorizontal.modelos.PropiedadHorizontalDTO;
import coremodel.datosbasicos.Identificacion;
import io.vavr.collection.List;

public interface PropiedadHorizontalCommunicator {

	List<PropiedadHorizontalDTO> obtenerTodasLasPropiedadesHorizontalesDeUnAdministrador(Identificacion identificacion);
}
