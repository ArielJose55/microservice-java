package co.com.ajac.ports;

import java.util.List;
import java.util.Optional;

import co.com.ajac.models.HistorialAccess;

public interface HistorialRepository {

	public boolean registerAccess(String serial, String identification);
	
	public Optional<List<HistorialAccess>> listHistoricalByDevice(String serial);
	
	public Optional<List<HistorialAccess>> listHistoricalByIdentification(String identification);
}
