package co.com.ajac.http.enpoints;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.domain.CommonProperty;
import co.com.ajac.usercases.common.FindAllCommonByHorizontal;
import co.com.ajac.usercases.common.FindOneCommon;
import co.com.ajac.usercases.common.RegisterCommon;

@RestController
@RequestMapping("/")
public class CommonPropertyEndpoint {

	@Autowired
	private RegisterCommon registerCommon;
	
	@Autowired
	private FindOneCommon findOneCommon;
	
	@Autowired
	private FindAllCommonByHorizontal findAllCommon;
	
	@PostMapping("/commons")
	public Integer registerCommonPropety(@Valid @RequestBody CommonProperty property) {
		return registerCommon.execute(property);
	}
	
	@GetMapping("/commons/{id}")
	public CommonProperty findOneCommonPropertyById(@PathVariable("id") Integer id) {
		return findOneCommon.execute(id); 
	}
	
	@GetMapping("{nit}/commons")
	public List<CommonProperty> findAllCommonPropertyByHorizontalProperty(@PathVariable("nit") String nit){
		return findAllCommon.execute(nit).asJava();
	}
}
