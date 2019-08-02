package co.com.ajac.database.repositories;

import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.database.repositories.acl.builders.HabitanteDatabaseBuilder;
import co.com.ajac.database.repositories.acl.builders.ResidenteDatabaseBuilder;
import co.com.ajac.database.repositories.habitante.HabitanteDAO;
import co.com.ajac.database.repositories.residente.ResidenteDAO;
import co.com.ajac.entities.residentes.Residente;
import co.com.ajac.entities.residentes.habitantes.Habitante;
import co.com.ajac.ports.ResidenteRepository;
import coremodel.datosbasicos.Identificacion;
import io.vavr.control.Option;

@Repository
public class ResidenteJdbiRepository implements ResidenteRepository{

	
	private final ResidenteDAO residenteDAO;
	private final HabitanteDAO habitanteDAO;
	
	@Autowired
	public ResidenteJdbiRepository(Jdbi jdbi) {
		this.residenteDAO = jdbi.onDemand(ResidenteDAO.class);
		this.habitanteDAO = jdbi.onDemand(HabitanteDAO.class);
	}

	@Override
	public Residente guardarResidenteCompleto(Residente resident) {
		residenteDAO.registrarResidente(ResidenteDatabaseBuilder.crearResidenteRecordDesdeEntidad(resident));
		return resident;
	}

	@Override
	public Habitante guardarHabitanteCompleto(Habitante habitante) {
		habitanteDAO.guardarHabitanteCompleto(
				HabitanteDatabaseBuilder.crearHabitanteRecordDesdeEntidad(habitante));
		return habitante;
	}

	@Override
	public Option<Residente> obtenerResidentePorSuIdentificacion(Identificacion identification) {
		return residenteDAO.obtenerResidentePorSuIdentificacion(
				identification.getTipoIdentificacion(),
				identification.getNumeroIdentificacion())
				.map(ResidenteDatabaseBuilder::crearResidenteDesdeRecord);
	}

	@Override
	public Option<Habitante> obtenerHabitantePorSuIdentificacion(Identificacion identification) {
		return habitanteDAO.obtenerHabitantePorSuIdentificacion(
				identification.getTipoIdentificacion(), 
				identification.getNumeroIdentificacion())
				.map(HabitanteDatabaseBuilder::crearHabitanteDesdeRecord);
	}
	
	
}
