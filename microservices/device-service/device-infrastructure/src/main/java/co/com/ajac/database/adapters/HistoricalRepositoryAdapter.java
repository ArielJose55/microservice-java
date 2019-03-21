package co.com.ajac.database.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.database.repositories.HistoricalJdbiRepository;
import co.com.ajac.models.HistorialAccess;
import co.com.ajac.ports.HistorialRepository;

@Component
public class HistoricalRepositoryAdapter implements HistorialRepository{

	private final HistoricalJdbiRepository repository;
	
	@Autowired
	public HistoricalRepositoryAdapter(HistoricalJdbiRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean registerAccess(String serial, String identification) {
		return repository.registerAccess(serial, identification);
	}

	@Override
	public Optional<List<HistorialAccess>> listHistoricalByDevice(String serial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<HistorialAccess>> listHistoricalByIdentification(String identification) {
		// TODO Auto-generated method stub
		return null;
	}

}
