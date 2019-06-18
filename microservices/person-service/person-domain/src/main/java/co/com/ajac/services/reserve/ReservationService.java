package co.com.ajac.services.reserve;

import java.text.MessageFormat;
import java.time.LocalDateTime;

import co.com.ajac.models.residents.Reservation;
import co.com.ajac.ports.NaturalPersonRepository;
import co.com.ajac.ports.PropertyCommunicator;
import co.com.ajac.ports.ReservationRepository;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ReservationService {
	
	private final NaturalPersonRepository naturalPersonRepository;
	private final PropertyCommunicator propertyCommunicator;
	private final ReservationRepository reservationRepository;

	public ReservationService(NaturalPersonRepository naturalPersonRepository, PropertyCommunicator propertyCommunicator, ReservationRepository reservationRepository) {
		this.naturalPersonRepository = naturalPersonRepository;
		this.propertyCommunicator = propertyCommunicator;
		this.reservationRepository = reservationRepository;
	}

	/**
	 * 
	 * @param reservation
	 * @return
	 */
	public Either<String, Option<Integer>> registerReservation(final Reservation reservation){
		log.info("Consultando la existencia en en sistema de alguna persona natural con identificacion {} ", reservation.getIdentification());
		Boolean existence = naturalPersonRepository.verifyExistence(reservation.getIdentification());
		
		if(existence) {
			log.info("Se encontro una persona registrada con esta identification {}", reservation.getIdentification());
			
			Option<Integer> optionCommon = propertyCommunicator.findCommonPropertyWithThisId(reservation.getBienComun());
			
			return optionCommon.fold(() -> 
				Either.left("Ouups! no existe ningun bien comun registrado en el sistema con este ID"),
				idCommon -> {
					List<Reservation> possibleReservations = reservationRepository
							.findAllReservationWithThisDates(reservation.getStartDate(), reservation.getFinishDate(), reservation.getBienComun());
					
					if(possibleReservations.peek(log::info).isEmpty()) {
						return Either.right(reservationRepository.registerReservation(reservation));
					}
					
					return Either.left(possibleReservations
							.map(reserve -> MessageFormat.format("Su reserva se cruza con otra en fecha de inicio: {0} y finalizacion: {1}", reserve.getStartDate(), reserve.getFinishDate())).mkString(", "));
				});
		}
		log.info("No existe ninguna persona natural registrada en el sistema con identificacion {}", reservation.getIdentification());
		return Either.left("Ouups! no existe ninguna persona natural registrada en el sistema con esta identificacion");
	}
	
	/**
	 * 
	 * @param state
	 * @param commonProperty
	 * @return
	 */
	public Either<String, List<Reservation>> findAllReservationByState(String state, Integer commonProperty){
		
		Option<Integer> optionCommon = propertyCommunicator.findCommonPropertyWithThisId(commonProperty);
		
		return optionCommon.fold(() -> 
			Either.left("Ouups! no existe ningun bien comun registrado en el sistema con este ID"),
			idCommon -> Either.right(reservationRepository.findAllReservationsByState(state, commonProperty)));
	
	}
	
	/**
	 * 
	 * @param identification
	 * @return
	 */
	public Either<String, Reservation> findOneReservationActiveNowByResident(String identification){
		
		boolean existence = naturalPersonRepository.verifyExistence(identification);
		
		if(existence) {
			Option<Reservation> optionReservation = reservationRepository.findOneReservationActiveNowBy(identification);
			
			return optionReservation.fold(() -> 
				Either.left("Esta persona no tiene en este momento reserva activa"),
				Either::right);
		}
		
		log.info("No existe ninguna persona natural registrada en el sistema con identificacion {}", identification);
		return Either.left("Ouups! no existe ninguna persona natural registrada en el sistema con esta identificacion");
	}
	
	/**
	 * 
	 * @param identification
	 * @return
	 */
	public Either<String, Reservation> findOneReservationActiveAtDate(LocalDateTime date){
		
		Option<Reservation> optionReservation = reservationRepository.findOneReservationActiveAtdate(date);

		return optionReservation.fold(() -> 
			Either.left("En esta fecha " + date + "no hay ninguna reserva activa"),
			Either::right);

	}
}
