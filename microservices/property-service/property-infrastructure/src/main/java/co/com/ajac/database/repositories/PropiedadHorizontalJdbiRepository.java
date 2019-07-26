package co.com.ajac.database.repositories;

import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.database.repositories.builders.propiedadhotizontal.PropiedadHorizontalDatabaseBuilder;
import co.com.ajac.database.repositories.propiedadhorizontal.propiedadhorizontal.PropiedadHorizontalDAO;
import co.com.ajac.database.repositories.transacciones.PropiedadHorizontalTransaction;
import co.com.ajac.domain.propiedadeshorizontales.Administrador;
import co.com.ajac.domain.propiedadeshorizontales.PropiedadHorizontal;
import co.com.ajac.repositories.PropiedadHorizontalRepository;
import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
public class PropiedadHorizontalJdbiRepository implements PropiedadHorizontalRepository{
	
	private final PropiedadHorizontalDAO propiedadHorizontalDAO;
	
	private final PropiedadHorizontalTransaction propiedadHorizontalTransaction;
	
	@Autowired
	public PropiedadHorizontalJdbiRepository(Jdbi jdbi) {
		this.propiedadHorizontalDAO = jdbi.onDemand(PropiedadHorizontalDAO.class);
		this.propiedadHorizontalTransaction = jdbi.onDemand(PropiedadHorizontalTransaction.class);
	}

	@Override
	public PropiedadHorizontal registrarPropiedadHorizontal(PropiedadHorizontal propiedadHorizontal) {
		log.debug("Persistiendo una propiedad horizontal: {}", propiedadHorizontal);
		propiedadHorizontalTransaction.guardarPropiedadHorizontalCompleta(
				PropiedadHorizontalDatabaseBuilder.crearPropiedadHorizontalRecordDesdeEntidad(propiedadHorizontal));
		return propiedadHorizontal;
	}

	@Override
	public Option<PropiedadHorizontal> obtenerPropiedadHorizontalPorNit(String nit) {
		log.debug("Consultando una propiedad horizontal por este NIT: {}", nit);
		return propiedadHorizontalDAO.obtenerPropiedadHorizontalPorNit(nit)
				.map(PropiedadHorizontalDatabaseBuilder::crearPropiedadHorizontalDesdeRecord)
				.orElse(Option.none());
	}

	@Override
	public List<PropiedadHorizontal> obtenerTodasPropiedadesHorizontalesPorAdministrador(Administrador administrador) {
		log.debug("Consultando todas las propiedades horizontales de este administrador: {}", administrador);
		return propiedadHorizontalDAO.obtenerTodasPropiedadesHorizontalesPorAdministrador(administrador)
				.peek(log::debug)
				.map(PropiedadHorizontalDatabaseBuilder::crearPropiedadHorizontalDesdeRecord);
	}

	
//	@Override
//	public List<PropiedadHorizontal> listAllHorizontalProperty(String identification) {	
//		return horizontalPropertyDAO.listAllHorizontalPropertyByAdmin(identification)
//				.map(HorizontalPropertyBuider::convertHorizontalPropertyFromRecord);
//	}

}
