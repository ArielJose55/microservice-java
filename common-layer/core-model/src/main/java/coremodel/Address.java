package coremodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	private String country;
	private String state;
	private String city;
	private String adress;
	private String localdescription;
}
