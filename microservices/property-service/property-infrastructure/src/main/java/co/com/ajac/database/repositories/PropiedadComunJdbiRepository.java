package co.com.ajac.database.repositories;

import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.database.repositories.builders.propiedadcomun.PropiedadComunDatabaseBuilder;
import co.com.ajac.database.repositories.propiedadcomun.PropiedadComunDAO;
import co.com.ajac.domain.propiedadeshorizontales.propiedadescomunes.PropiedadComun;
import co.com.ajac.repositories.PropiedadComunRepository;
import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
public class PropiedadComunJdbiRepository implements PropiedadComunRepository {

	private final PropiedadComunDAO propiedadComunDAO;
	
	@Autowired
	public PropiedadComunJdbiRepository(Jdbi jdbi) {
		this.propiedadComunDAO = jdbi.onDemand(PropiedadComunDAO.class);
	}

	@Override
	public PropiedadComun guardarPropiedadCommun(PropiedadComun propiedadComun) {
		log.debug("Se procede a persistir la propiedad comun: {}", propiedadComun);
		propiedadComunDAO.guardarPropiedadComun(PropiedadComunDatabaseBuilder.crearPropiedadComunRecordDesdeEntidad(propiedadComun));
		return propiedadComun;
	}

	@Override
	public Option<PropiedadComun> obtenerPropiedadComun(Integer id) {
		return propiedadComunDAO.obtenerPropiedadComunPorSuId(id)
				.map(PropiedadComunDatabaseBuilder::crearPropiedadComunDesdeRecord);
	}

	@Override
	public List<PropiedadComun> obtenerPropiedadesComunesDeUnaPropiedadHorizontal(String nit) {
		return propiedadComunDAO.obtenerPropiedadesComunesPorSuPropiedadHorizontal(nit)
				.map(PropiedadComunDatabaseBuilder::crearPropiedadComunDesdeRecord);
	}

	
	
}
