package co.com.ajac.usecase.resident;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.exceptions.ModelNotFoundException;
import co.com.ajac.models.Resident;
import co.com.ajac.services.resident.ResidentService;
import common.usecases.Query;

@Component
public class GetResident implements Query<Resident, String> {

	private static final String RESIDENT_NOT_FOUND = "El residente con esta identificación no existe";
	private final ResidentService residentService;

	@Autowired
	public GetResident(ResidentService residentService) {
		this.residentService = residentService;
	}

	@Override
	public Resident execute(String identification) {
		return residentService.get(identification)
				.orElseThrow(() -> new ModelNotFoundException(RESIDENT_NOT_FOUND));
	}
	
}
