package co.com.ajac.database.adapters;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.database.repositories.JdbiPropertyRepository;
import co.com.ajac.domain.HorizontalProperty;
import co.com.ajac.ports.PropertyRespository;

@Component
public class PropertyRepositoryAdapter implements PropertyRespository{

	@Autowired
	private JdbiPropertyRepository repository;
	
	@Override
	public Optional<HorizontalProperty> register(HorizontalProperty horizontalProperty) {
		return repository.register(horizontalProperty);
	}

	@Override
	public Optional<HorizontalProperty> findOne(Integer id) {
		return repository.getOne(id, false);
	}

	@Override
	public Optional<HorizontalProperty> fidnOneWithAttributes(Integer id) {
		return repository.getOne(id, true);
	}

}
