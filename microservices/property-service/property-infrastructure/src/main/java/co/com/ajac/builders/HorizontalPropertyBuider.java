package co.com.ajac.builders;

import co.com.ajac.database.repositories.horizontalproperty.HorizontalPropertyRecord;
import co.com.ajac.domain.HorizontalProperty;
import io.vavr.collection.List;

public class HorizontalPropertyBuider {
	
	private HorizontalPropertyBuider() {}
	
	public static HorizontalProperty convertHorizontalPropertyFromRecord(HorizontalPropertyRecord horizontalPropertyRecord) {
		
		return HorizontalProperty.builder()
				.id(horizontalPropertyRecord.getId())
				.distinctiveName(horizontalPropertyRecord.getDistinctiveName())
				.bienesCommunes(List.empty())
				.bienesPrivados(List.empty())
				.build();
	}

}
