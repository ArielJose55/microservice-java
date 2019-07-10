package co.com.ajac.database.repositories.adapters;

import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.domain.CommonProperty;
import co.com.ajac.ports.repositories.CommonPropertyRepository;
import io.vavr.collection.List;
import io.vavr.control.Option;

@Repository
public class CommonPropertyJdbiRepository implements CommonPropertyRepository{

	@Autowired
	public CommonPropertyJdbiRepository(Jdbi jdbi) {
		
	}

	@Override
	public List<CommonProperty> findAllCommonPropertyBy(String nitHorizontalProperty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Option<Integer> registerCommonProperty(CommonProperty property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Option<CommonProperty> findOneCommonProperty(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
