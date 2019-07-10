package co.com.ajac.domain;


import coremodel.LegalPerson;
import io.vavr.collection.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HorizontalProperty extends LegalPerson{
	
	private Integer id;
	
	private String distinctiveName;
	
	private List<CommonProperty> bienesCommunes;
	
	private List<PrivateProperty> bienesPrivados;

	public HorizontalProperty(String identification, String typeIdentification) {
		super(identification, typeIdentification);
	}
	
	public HorizontalProperty(String identification, String typeIdentification, String distinctiveName, String businessName, String socialObjective) {
		super(identification, typeIdentification, businessName, socialObjective);
		this.distinctiveName = distinctiveName;
	}	
}
