package co.com.ajac.database.adapters;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.database.repositories.ReservationJdbiRepository;
import co.com.ajac.entities.residentes.Reservation;
import co.com.ajac.ports.ReservationRepository;
import io.vavr.collection.List;
import io.vavr.control.Option;

@Component
public class ReservationRepositoryAdapter implements ReservationRepository{

	@Autowired
	private ReservationJdbiRepository repository;

	@Override
	public Option<Integer> registerReservation(Reservation reservation) {
		return repository.registerReservation(reservation);
	}

	@Override
	public List<Reservation> findAllReservationWithThisDates(LocalDateTime startDate, LocalDateTime finishDate,
			Integer commonProperty) {
		return repository.listReservationWithThisDates(startDate, finishDate, commonProperty);
	}

	@Override
	public List<Reservation> findAllReservationsByState(String state, Integer commonProperty) {
		return repository.listReservationByState(state, commonProperty);
	}

	@Override
	public Option<Reservation> findOneReservationActiveNowBy(String identification) {
		return repository.findOneReservationActiveNowBy(identification);
	}

	@Override
	public Option<Reservation> findOneReservationActiveAtdate(LocalDateTime date) {
		return repository.findOneReservationActiveAtDate(date);
	}

	
}
