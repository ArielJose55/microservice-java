package co.com.ajac.usecases.device;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.models.Device;
import co.com.ajac.services.DeviceService;
import common.Query;
import io.vavr.collection.List;

@Component
public class FindAllDevice implements Query<List<Device>, Integer>{

	private final DeviceService service;
	
	@Autowired
	public FindAllDevice(DeviceService service) {
		this.service = service;
	}

	@Override
	public List<Device> execute(Integer commonProperty) {
		return service.listDevicesByProperty(commonProperty);
	}
}
