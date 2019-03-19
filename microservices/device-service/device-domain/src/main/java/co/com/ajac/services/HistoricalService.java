package co.com.ajac.services;

import java.util.List;
import java.util.Optional;

import co.com.ajac.models.HistorialAccess;
import co.com.ajac.ports.HistorialRepository;

public class HistoricalService {

	private final HistorialRepository historialRepository;

	public HistoricalService(HistorialRepository historialRepository) {
		this.historialRepository = historialRepository;
	}
	
	public boolean registerAccess(Integer device, String identification) {
		return historialRepository.registerAccess(device, identification);
	}
	
	public Optional<List<HistorialAccess>> historicalByDevices(String serial) {
		return historialRepository.listHistoricalByDevice(serial);
	}
	
	public Optional<List<HistorialAccess>> historicalByIdentification(String identification) {
		return historialRepository.listHistoricalByIdentification(identification);
	}
}
