package co.com.ajac.domain.pps;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Resident {

	private final String typeIdentification;
	private final String numberIdentification;
	
}
