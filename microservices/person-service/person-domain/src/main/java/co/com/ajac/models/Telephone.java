package co.com.ajac.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Telephone {

	private String numberPhone;
	
	private boolean preference;
	
	private String indicative;
	
	private String type;
	
	private String identification;
}
