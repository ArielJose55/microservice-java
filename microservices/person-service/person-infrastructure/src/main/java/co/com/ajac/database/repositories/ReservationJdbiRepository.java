package co.com.ajac.database.repositories;

import java.time.LocalDateTime;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.entities.residentes.Reservation;
import io.vavr.Function0;
import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.Cleanup;


@Repository
public class ReservationJdbiRepository {

	private static final String FIND_ALL_RESERVATION_BETWEEN = "SELECT * FROM \"RESERVATION\" re WHERE re.common_property = :commonProperty AND re.state = 'ANSWERED'" + 
			"\tEXCEPT\t" + 
			"SELECT * FROM \"RESERVATION\" re" + 
				"\tWHERE (re.finish_date < :startDate OR re.start_date > :finishDate)" + 
				"\tAND re.common_property = :commonProperty AND re.state = 'ANSWERED'";
	
	private static final String INSERT_RESERVATION_BETWEEN = "INSERT INTO public.\"RESERVATION\"( description, answer, start_date, finish_date, common_property, identification_resident)\n" + 
			"\tVALUES (:description, :answer, :startDate, :finishDate, :bienComun, :identification)";
	
	private static final String FIND_ALL_RESERVATIONS_BY_STATE_AND_COMMON_PROPERTY = "SELECT * FROM public.\"RESERVATION\" re" + 
		"\tWHERE re.state =:state AND re.common_property=:commonProperty";
	
	private static final String FIND_ONE_RESERVATION_ACTIVE_NOW_BY_IDENTIFICATION = "SELECT * FROM \"RESERVATION\" re" + 
		"\tWHERE (now() BETWEEN re.start_date AND re.finish_date)" + 
			"\tAND re.identification_resident = :identification" + 
			"\tAND re.state = 'ANSWERED'";
	
	private static final String FIND_ONE_RESERVATION_ACTIVE_AT_DATE= "SELECT * FROM \"RESERVATION\" re" + 
			"\tWHERE (:date BETWEEN re.start_date AND re.finish_date)" + 
				"\tAND re.state = 'ANSWERED'";
	@Autowired
	private Jdbi jdbi;
	
	/**
	 * 
	 * @param reservation
	 * @return
	 */
	public Option<Integer> registerReservation(final Reservation reservation){
		
		@Cleanup
		final Handle handle = jdbi.open();
		
		final Function0<Integer> register = () -> handle.createUpdate(INSERT_RESERVATION_BETWEEN)
				.bindBean(reservation)
				.executeAndReturnGeneratedKeys("id")
				.mapTo(Integer.class)
				.findOnly();
		
		return Function0.lift(register).apply();
	}
	
	/**
	 * 
	 * @param startDate
	 * @param finishDate
	 * @param commonProperty
	 * @return
	 */
	public List<Reservation> listReservationWithThisDates(LocalDateTime startDate, LocalDateTime finishDate, Integer commonProperty){
		
		@Cleanup
		final Handle handle = jdbi.open();
		
		final Function0<List<Reservation>> findAll = () -> List.ofAll(handle.createQuery(FIND_ALL_RESERVATION_BETWEEN)
				.bind("startDate", startDate)
				.bind("finishDate", finishDate)
				.bind("commonProperty", commonProperty)
				.mapToBean(Reservation.class)
				.list());
		
		return Function0.lift(findAll).apply().getOrElse(List.empty());
	}
	
	/**
	 * 
	 * @param state
	 * @param commonProperty
	 * @return
	 */
	public List<Reservation> listReservationByState(String state, Integer commonProperty){
	
		@Cleanup
		final Handle handle = jdbi.open();
		
		final Function0<List<Reservation>> findAllByState = () -> List.ofAll(handle.createQuery(FIND_ALL_RESERVATIONS_BY_STATE_AND_COMMON_PROPERTY)
				.bindBySqlType("state", state, java.sql.Types.OTHER)
				.bind("commonProperty", commonProperty)
				.mapToBean(Reservation.class)
				.list());
		return Function0.lift(findAllByState).apply().getOrElse(List.empty());
	}
	
	/**
	 * 
	 * @param identification
	 * @return
	 */
	public Option<Reservation> findOneReservationActiveNowBy(String identification){
		
		@Cleanup
		final Handle handle = jdbi.open();
		
		final Function0<Reservation> findOne = () -> {
			return handle.createQuery(FIND_ONE_RESERVATION_ACTIVE_NOW_BY_IDENTIFICATION)
					.bind("identification", identification)
					.mapToBean(Reservation.class)
					.findOnly();
		};
		
		return Function0.lift(findOne).apply();
	}
	
	/**
	 * 
	 * @param identification
	 * @return
	 */
	public Option<Reservation> findOneReservationActiveAtDate(LocalDateTime date){
		
		@Cleanup
		final Handle handle = jdbi.open();
		
		final Function0<Reservation> findOne = () -> {
			return handle.createQuery(FIND_ONE_RESERVATION_ACTIVE_AT_DATE)
					.bind("date", date)
					.mapToBean(Reservation.class)
					.findOnly();
		};
		
		return Function0.lift(findOne).apply();
	}
}
