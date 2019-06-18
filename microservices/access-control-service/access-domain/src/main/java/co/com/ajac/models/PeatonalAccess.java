package co.com.ajac.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PeatonalAccess extends Access{

	private String identification;
	
	public static PeatonalAccess create(String serial, String identification) {
		PeatonalAccess peatonalAccess = new PeatonalAccess();
		peatonalAccess.setSerial(serial);
		peatonalAccess.setIdentification(identification);
		peatonalAccess.set
	}
}
