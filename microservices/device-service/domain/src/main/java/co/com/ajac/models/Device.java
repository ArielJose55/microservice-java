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
public class Device {

	@NotBlank(message = "")
	private String serial;
	
	@NotBlank(message = "")
	private String fingerprint;
	
	@NotBlank(message = "")
	@Pattern(regexp = "", message = "")
	private String securityCode;
	
	@NotBlank(message = "")
	private String bienComun;
}
