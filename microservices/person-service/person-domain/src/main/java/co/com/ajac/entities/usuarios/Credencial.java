package co.com.ajac.entities.usuarios;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@RequiredArgsConstructor
public class Credencial {

	private final String username;

	private final String password;
}
