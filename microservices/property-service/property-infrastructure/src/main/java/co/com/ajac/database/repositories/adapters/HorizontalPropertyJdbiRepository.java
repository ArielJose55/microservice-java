package co.com.ajac.database.repositories.adapters;

import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.builders.HorizontalPropertyBuider;
import co.com.ajac.database.repositories.horizontalproperty.HorizontalPropertyDAO;
import co.com.ajac.domain.HorizontalProperty;
import co.com.ajac.ports.repositories.HorizontalPropertyRespository;
import io.vavr.collection.List;
import io.vavr.control.Option;

@Repository
public class HorizontalPropertyJdbiRepository implements HorizontalPropertyRespository{
	
	private final HorizontalPropertyDAO horizontalPropertyDAO;
	
	@Autowired
	public HorizontalPropertyJdbiRepository(Jdbi jdbi) {
		this.horizontalPropertyDAO = jdbi.onDemand(HorizontalPropertyDAO.class);
	}

	@Override
	public Option<String> registerHorizontalProperty(HorizontalProperty horizontalProperty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Option<String> findOneHorizonalProperty(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HorizontalProperty> listAllHorizontalProperty(String identification) {	
		return horizontalPropertyDAO.listAllHorizontalPropertyByAdmin(identification)
				.map(HorizontalPropertyBuider::convertHorizontalPropertyFromRecord);
	}

}
