package co.com.ajac.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.domain.CommonProperty;
import co.com.ajac.domain.HorizontalProperty;
import co.com.ajac.dtos.HorizontalPropertyDTO;
import co.com.ajac.services.common.CommonService;
import co.com.ajac.services.horizontal.HorizontalService;
import domain.exceptions.ModelNotFoundException;
import io.vavr.control.Either;

@Component
public class PropertyQueryResource {

	private final HorizontalService horizontalService;
	private final CommonService commonService;

	@Autowired
	public PropertyQueryResource(HorizontalService horizontalService, CommonService commonService) {
		this.horizontalService = horizontalService;
		this.commonService = commonService;
	}
	
	public List<HorizontalPropertyDTO> listAllPropetyByAdministrator(String identification){
		 io.vavr.collection.List<HorizontalProperty> listHorizontalProperties = horizontalService.listAllHorizontalPropertyByAdministrator(identification);
		 
		 return listHorizontalProperties.map(ph -> HorizontalPropertyDTO.builder()
				 .id(ph.getId())
				 .nameDistintive(ph.getDistinctiveName())
				 .numId(ph.getIdentification())
				 .build())
			.toJavaList();
	}
	
	public List<CommonProperty> listAllCommonByHorizontalProperty(String nit) {
		return commonService.findAllCommonByHorizontalProperty(nit).toJavaList();
	}
	
	public CommonProperty getOneCommonProperty(Integer id) {
		Either<String, CommonProperty> eitherResult = commonService.findOneCommonProperty(id);
		return eitherResult.getOrElseThrow(() -> new ModelNotFoundException(eitherResult.getLeft()));
	}
}
