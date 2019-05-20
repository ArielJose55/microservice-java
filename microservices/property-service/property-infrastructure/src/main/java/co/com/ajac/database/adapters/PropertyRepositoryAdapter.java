package co.com.ajac.database.adapters;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.database.repositories.PropertyJdbiRepository;
import co.com.ajac.domain.HorizontalProperty;
import co.com.ajac.ports.PropertyRespository;
import io.vavr.control.Option;

@Component
public class PropertyRepositoryAdapter implements PropertyRespository{

	@Autowired
	private PropertyJdbiRepository repository;

	@Override
	public Option<String> registerHorizontalProperty(HorizontalProperty horizontalProperty) {
		return repository.register(horizontalProperty);
	}

	@Override
	public Option<HorizontalProperty> findOneHorizonalProperty(Integer id) {
		return repository.findOne(id);
	}
	
}
