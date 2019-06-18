package co.com.ajac.ports;

import java.time.LocalDateTime;

import co.com.ajac.models.residents.Reservation;
import io.vavr.collection.List;
import io.vavr.control.Option;

public interface ReservationRepository {
	
	Option<Integer> registerReservation(Reservation reservation);
	
	List<Reservation> findAllReservationWithThisDates(LocalDateTime startDate, LocalDateTime finishDate, Integer commonProperty);
	
	List<Reservation> findAllReservationsByState(String state, Integer commonProperty);
	
	Option<Reservation> findOneReservationActiveNowBy(String identification);
	
	Option<Reservation> findOneReservationActiveAtdate(LocalDateTime date);
}
