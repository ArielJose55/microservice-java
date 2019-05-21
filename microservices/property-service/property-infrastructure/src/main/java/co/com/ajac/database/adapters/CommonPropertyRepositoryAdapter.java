package co.com.ajac.database.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.database.repositories.CommonJdbiRepository;
import co.com.ajac.domain.CommonProperty;
import co.com.ajac.ports.CommonPropertyRepository;
import io.vavr.collection.List;
import io.vavr.control.Option;

@Component
public class CommonPropertyRepositoryAdapter implements CommonPropertyRepository{

	@Autowired
	private CommonJdbiRepository repository;
	
	@Override
	public List<CommonProperty> findAllCommonPropertyBy(String nitHorizontalProperty) {
		return repository.findAllCommonPropertyBy(nitHorizontalProperty);
	}

	@Override
	public Option<Integer> registerCommonProperty(CommonProperty property) {
		return repository.registerCommonProperty(property);
	}

	@Override
	public Option<CommonProperty> findOneCommonProperty(Integer id) {
		return repository.findOneBy(id);
	}
}
