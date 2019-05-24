package co.com.ajac.usecase.reserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.models.residents.Reservation;
import co.com.ajac.services.reserve.ReservationService;
import common.Query;
import domain.exceptions.ModelNotFoundException;
import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.control.Either;

@Component
public class FindAllReserveByState implements Query<List<Reservation>, Tuple2<String, Integer>>{

	private final ReservationService service;

	@Autowired
	public FindAllReserveByState(ReservationService service) {
		this.service = service;
	}

	@Override
	public List<Reservation> execute(Tuple2<String, Integer> arg0) {
		Either<String, List<Reservation>> eitherResult = service.findAllReservationByState(arg0._1, arg0._2);
		return eitherResult.getOrElseThrow(() -> new ModelNotFoundException(eitherResult.getLeft()));
	}

		
}
