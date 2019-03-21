package co.com.ajac.database.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.database.repositories.DeviceJdbiRepository;
import co.com.ajac.models.Device;
import co.com.ajac.ports.DeviceRepository;

@Component
public class DeviceRepositoryAdapter implements DeviceRepository{

	private final DeviceJdbiRepository repository;
	
	@Autowired
	public DeviceRepositoryAdapter(DeviceJdbiRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean addDevice(Device device) {
		return repository.save(device);
	}

	@Override
	public Optional<Device> getDevice(String serial) {
		return repository.getDevice(serial);
	}

	@Override
	public Optional<List<Device>> listDevicesByProperty(Integer property) {
		return null;
	}
}
