package co.com.ajac.database.repositories.habitante;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;

import io.vavr.control.Option;

public interface HabitanteDAO {

	boolean guardarHabitanteCompleto(
			@BindBean("habitante") HabitanteRecord habitanteRecord);
	
	Option<HabitanteRecord> obtenerHabitantePorSuIdentificacion(
			@Bind("tipoId") String tipoId,
			@Bind("numId") String numId);
}
