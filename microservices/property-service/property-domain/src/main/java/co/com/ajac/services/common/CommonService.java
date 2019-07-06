package co.com.ajac.services.common;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Patterns.$None;
import static io.vavr.Patterns.$Some;

import co.com.ajac.domain.CommonProperty;
import co.com.ajac.ports.CommonPropertyRepository;
import co.com.ajac.ports.PropertyRespository;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CommonService {

	private final CommonPropertyRepository commonPropertyRepository;
	private final PropertyRespository propertyRespository;

	public CommonService(CommonPropertyRepository commonPropertyRepository, PropertyRespository propertyRespository) {
		this.commonPropertyRepository = commonPropertyRepository;
		this.propertyRespository = propertyRespository;
	}
	
	/**
	 * 
	 * @param property
	 * @return
	 */
	public Either<String, Option<Integer>> registerCommonProperty(CommonProperty property){
		
		log.info("verificando la existencia de una propiedad horizontal con nit {} en el sistema", property.getNitHorizantalProperty());
		
		Option<String> verifyExistence = propertyRespository.findOneHorizonalProperty(property.getNitHorizantalProperty());
		
		Option<List<CommonProperty>> orElse = verifyExistence.map(commonPropertyRepository::findAllCommonPropertyBy)
				.orElse(Option.none());
		
		return Match(orElse).of(
				Case($Some($()), list -> {
					
					Option<CommonProperty> existenceOne = list.find( pro -> pro.getName().equals(property.getName()) && pro.isEssential() == property.isEssential());
				
					return Match(existenceOne).of(
							Case($Some($()), one -> Either.left("Ouup! Ya existe un bien comun registrado en nuestro sistema para esta propiedad horizontal")),
							Case($None(), none -> Either.right(commonPropertyRepository.registerCommonProperty(property)))
							);					                                                                                                
				}),
				Case($None(), Either.left("Oups! no tenemos registro de ninguna propiedad horizontal registrada con este nit: " + property.getNitHorizantalProperty()))
				);
		
		
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Either<String, CommonProperty> findOneCommonProperty(Integer id){
		
		Option<CommonProperty> oneOptionResult = commonPropertyRepository.findOneCommonProperty(id);
		
		return Match(oneOptionResult).of(
				Case($Some($()), common -> Either.right(common)),
				Case($None(), Either.left("No exite ningun bien comun identitificado con este ID en nuestro sistema"))
				);
	}
	
	/**
	 * 
	 * @param nit
	 * @return
	 */
	public List<CommonProperty> findAllCommonByHorizontalProperty(String nit){
		return commonPropertyRepository.findAllCommonPropertyBy(nit);
	}
}
