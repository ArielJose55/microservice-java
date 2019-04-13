package co.com.ajac.usecases.device;

import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ajac.models.Device;
import common.usecases.Query;

@Component
public class FindAllDevice implements Query<List<Device>, Integer>{

	@Override
	public List<Device> execute(Integer arg0) {
		return null;
	}

}
