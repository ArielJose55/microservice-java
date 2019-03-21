package co.com.ajac.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Device implements Model{

	@NotBlank(message = "")
	private String serial;
	
	@NotBlank(message = "")
	private String name;
	
	@NotBlank(message = "")
	@Pattern(regexp = "", message = "")
	private String securityCode;
	
	@NotBlank(message = "")
	private String state;
	
	@NotBlank(message = "")
	private Integer bienComun;
}
