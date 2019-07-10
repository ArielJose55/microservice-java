package co.com.ajac.database.repositories.horizontalproperty;

import co.com.ajac.database.repositories.commonsproperty.CommonPropertyRecord;
import co.com.ajac.database.repositories.privatesproperty.PrivatePropertyRecord;
import io.vavr.collection.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HorizontalPropertyRecord {
	
	private final Integer id;
	private final String distinctiveName;
	private final String nitIdentification;
	private final List<CommonPropertyRecord> commonsProperties;
	private final List<PrivatePropertyRecord> privatesProperties;

}
