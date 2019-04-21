package co.com.ajac.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	private String country;
	private String state;
	private String city;
	private String adress;
	private String localdescription;
	private String identification;
}
