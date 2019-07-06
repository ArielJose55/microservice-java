package coremodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Telephone {

	private String numberPhone;
	private Boolean preference;
	private String indicative;
	private TypePhone typePhone;
}
