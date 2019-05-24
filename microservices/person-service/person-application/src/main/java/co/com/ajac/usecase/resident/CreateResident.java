package co.com.ajac.usecase.resident;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.exceptions.NotSaveModelException;
import co.com.ajac.models.residents.Resident;
import co.com.ajac.services.resident.ResidentService;
import common.Query;


@Component
public class CreateResident implements Query<Resident,Resident>{
	
	private static final String UNREGISTERED_RESIDENT = "¡Ouups! Lo sentimos este residente no pudo ser registrado. Intentelo nuevamente";
	private final ResidentService residentService;

	@Autowired
	public CreateResident(ResidentService residentService) {
		this.residentService = residentService;
	}

	@Override
	public Resident execute(Resident resident) {
		return residentService.create(resident)
				.getOrElseThrow(() -> new NotSaveModelException(UNREGISTERED_RESIDENT));
	}

}
