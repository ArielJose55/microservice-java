package co.com.ajac.commands;

import co.com.ajac.dtos.CommonPropertyDTO;
import co.com.ajac.services.common.CommonService;

//@Component
public class RegisterCommonProperty implements Command<CommonPropertyDTO>{

	private final CommonService service;
	
	//@Autowired
	public RegisterCommonProperty(CommonService service) {
		this.service = service;
	}

	@Override
	public void execute(CommonPropertyDTO property) {
	
//		Either<String, Option<Integer>> eitherResult = service.registerCommonProperty(property);		
//		eitherResult.getOrElseThrow(
//				() -> new NotSaveModelException(eitherResult.getLeft()))
//				.getOrElseThrow(() -> new NotSaveModelException("Oups! No fue posible registrar este bien comun"));
	}
}
