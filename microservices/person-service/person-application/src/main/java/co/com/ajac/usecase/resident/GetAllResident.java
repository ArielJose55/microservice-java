package co.com.ajac.usecase.resident;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.exceptions.ModelNotFoundException;
import co.com.ajac.models.residents.Resident;
import co.com.ajac.services.resident.ResidentService;
import common.Command;

@Component
public class GetAllResident implements Command<List<Resident>>{

	private static final String RESIDENTS_NOT_FOUND = "¡OuupS! Aún no hay residentes registrados";
	private final ResidentService residentService;
	
	@Autowired
	public GetAllResident(ResidentService residentService) {
		this.residentService = residentService;
	}

	@Override
	public List<Resident> execute() {
		return residentService.getAll()
				.orElseThrow(() -> new ModelNotFoundException(RESIDENTS_NOT_FOUND));
	}
}
