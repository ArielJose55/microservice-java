package co.com.ajac.http.enpoints;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.domain.CommonProperty;
import co.com.ajac.usercases.common.RegisterCommon;

@RestController
@RequestMapping("/")
public class CommonPropertyEndpoint {

	@Autowired
	private RegisterCommon registerCommon;
	
	@PostMapping("/commons")
	public Integer registerCommonPropety(@Valid @RequestBody CommonProperty property) {
		System.out.println(property);
		return registerCommon.execute(property);
	}
}
