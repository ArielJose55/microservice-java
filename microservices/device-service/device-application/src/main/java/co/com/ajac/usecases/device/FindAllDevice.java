package co.com.ajac.usecases.device;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import co.com.ajac.models.Device;
import common.usecases.Query;

@Component
public class FindAllDevice implements Query<List<Device>, Integer>{

	@Override
	public Optional<List<Device>> execute(Integer arg0) {
		return null;
	}

}
