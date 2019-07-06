package co.com.ajac.services.horizontal;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Patterns.$None;
import static io.vavr.Patterns.$Some;

import co.com.ajac.domain.HorizontalProperty;
import co.com.ajac.ports.PersonCommunicator;
import co.com.ajac.ports.PropertyRespository;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;

public class HorizontalService {

	private final PropertyRespository propertyRespository;
	private final PersonCommunicator personCommunicator;

	public HorizontalService(PropertyRespository propertyRespository, PersonCommunicator personCommunicator) {
		this.propertyRespository = propertyRespository;
		this.personCommunicator = personCommunicator;
	}
	
	public Either<String, Option<String>> registerHorizontalProperty(HorizontalProperty property) {
		Option<String> optionProperty = personCommunicator.getIdProperty(property.getIdentification(), "HORIZONTAL_PROPERTY");
		
		return optionProperty.fold(() ->  {
			Option<String> optionIdLegalPerson = personCommunicator.registerLegalPerson(property);
			return Match(optionIdLegalPerson).of(
					Case($Some($()), idLegalPerson -> Either.right(propertyRespository.registerHorizontalProperty(property))),
					Case($None(), Either.left("Lo sentimos, no fue posible registrar esta propiedad horizontal"))
					);
		}, nit -> Either.left("Este Nit: " + nit + " ya se encuentra registrado en nuestro sistema"));
	}
	
	public List<HorizontalProperty> listAllHorizontalPropertyByAdministrator(String identification){
		return propertyRespository.listAllHorizontalProperty(identification);
	}
}
