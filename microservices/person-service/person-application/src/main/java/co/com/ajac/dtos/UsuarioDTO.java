package co.com.ajac.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UsuarioDTO {

	private String username;
	private String password;
	private String numeroIdentificacion;
	private String tipoIdentificacion;
	private String token;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String nombreCompleto;
	private String tipoUsuario;
	
}
