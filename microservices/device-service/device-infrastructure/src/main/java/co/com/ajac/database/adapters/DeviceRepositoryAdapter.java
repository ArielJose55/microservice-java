package co.com.ajac.database.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.database.repositories.DeviceJdbiRepository;
import co.com.ajac.models.Device;
import co.com.ajac.ports.DeviceRepository;
import io.vavr.collection.List;
import io.vavr.control.Option;

@Component
public class DeviceRepositoryAdapter implements DeviceRepository{

	private final DeviceJdbiRepository repository;
	
	@Autowired
	public DeviceRepositoryAdapter(DeviceJdbiRepository repository) {
		this.repository = repository;
	}

	@Override
	public Option<String> regsterDevice(Device device) {
		return repository.save(device);
	}

	@Override
	public Option<Device> getDevice(String serial) {
		return repository.getDevice(serial);
	}

	@Override
	public List<Device> listDevicesByProperty(Integer bienComun) {
		return repository.getAllDeviceByBienComun(bienComun);
	}
}
