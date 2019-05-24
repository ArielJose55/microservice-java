package co.com.ajac.models.residents;

import javax.validation.constraints.NotEmpty;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

	private static final String FIELD_NOT_EMPTY = "Este campo no puede estar vacio";
	
	@NotEmpty(message = FIELD_NOT_EMPTY)
	private String name;
	
	@NotEmpty(message = FIELD_NOT_EMPTY)
	private String species;
	
	@NotEmpty(message = FIELD_NOT_EMPTY)
	private String identification;
}
