package co.com.ajac.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonProperty {
	
	private Integer id;

	private String name;
	
	private boolean essential;
	
	private Integer idHorizantalProperty;
}
