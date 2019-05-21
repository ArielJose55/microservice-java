package co.com.ajac.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import coremodel.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Device implements Model{
	
	private Integer id;
	
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

	public Device( String serial, String name, String state, Integer bienComun) {
		this.serial = serial;
		this.name = name;
		this.state = state;
		this.bienComun = bienComun;
	}
}
