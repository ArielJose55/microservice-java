package co.com.ajac.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	
	private String state;
	
	@NotNull(message = "")
	private Integer bienComun;

	public Device(String serial, String name, Integer bienComun) {
		this.serial = serial;
		this.name = name;
		this.bienComun = bienComun;
	}
}
