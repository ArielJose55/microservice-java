package co.com.ajac.database.repositories.commonsproperty;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommonPropertyRecord {
	
	private final Integer id;
	private final String name;
	private final Boolean essential;
	
}
