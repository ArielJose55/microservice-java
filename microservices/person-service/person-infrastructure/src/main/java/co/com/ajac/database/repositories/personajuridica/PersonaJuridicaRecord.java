package co.com.ajac.database.repositories.personajuridica;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class PersonaJuridicaRecord {

	private final String nit;
	private final String razonSocial;
	private final String objetoSocial;
}
