package co.com.ajac.database.repositories;

import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.database.repositories.builders.propiedadprivada.PropiedadPrivadaDatabaseBuilder;
import co.com.ajac.database.repositories.propiedadprivada.PropiedadPrivadaDAO;
import co.com.ajac.domain.propiedadeshorizontales.propiedadesprivadas.PropiedadPrivada;
import co.com.ajac.repositories.PropiedadPrivadaRepository;
import io.vavr.collection.List;
import io.vavr.control.Option;

@Repository
public class PropiedadPrivadaJdbiRepository implements PropiedadPrivadaRepository{

	private final PropiedadPrivadaDAO propiedadPrivadaDAO;
	
	@Autowired
	public PropiedadPrivadaJdbiRepository(Jdbi jdbi) {
		this.propiedadPrivadaDAO = jdbi.onDemand(PropiedadPrivadaDAO.class);
	}
	
	@Override
	public PropiedadPrivada guardarPropiedadPrivada(PropiedadPrivada propiedadPrivada) {
		propiedadPrivadaDAO.guardarPropiedadPrivada(
				PropiedadPrivadaDatabaseBuilder.crearPropiedadPrivadaRecordDesdeEntidad(propiedadPrivada));
		return propiedadPrivada;
	}

	@Override
	public Option<PropiedadPrivada> obtenerPropiedadPrivada(Integer id) {
		return propiedadPrivadaDAO.obtenerPropiedadPrivadaPorSuId(id)
				.map(PropiedadPrivadaDatabaseBuilder::crearPropiedadPrivadaDesdeRecord);
	}

	@Override
	public List<PropiedadPrivada> obtenerPropiedadesPrivadasDeUnaPropiedadHorizontal(String nit) {
		return propiedadPrivadaDAO.obtenerPropiedadesPrivadaPorSuPropiedadHorizontal(nit)
				.map(PropiedadPrivadaDatabaseBuilder::crearPropiedadPrivadaDesdeRecord);
	}
}
