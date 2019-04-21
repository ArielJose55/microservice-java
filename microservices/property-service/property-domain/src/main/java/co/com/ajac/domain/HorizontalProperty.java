package co.com.ajac.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HorizontalProperty {

	private Integer id;
	
	private String distinctiveName;
	
	private List<CommonProperty> commonProperties;
	
	private List<PrivateProperty> privateProperties;

	public HorizontalProperty(String distinctiveName) {
		this.distinctiveName = distinctiveName;
	}
}
