package co.com.ajac.domain.cps;

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
	
	private String nitHorizantalProperty;

	@Override
	public String toString() {
		return "CommonProperty [id=" + id + ", name=" + name + ", essential=" + essential + ", nitHorizantalProperty="
				+ nitHorizantalProperty + "]";
	}
}
