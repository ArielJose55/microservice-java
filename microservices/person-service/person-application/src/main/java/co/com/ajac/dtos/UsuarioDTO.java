package co.com.ajac.dtos;


import java.util.List;

import co.com.ajac.acl.propiedadhorizontal.modelos.PropiedadHorizontalDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

	private String numeroIdentificacion;
	private String tipoIdentificacion;
	private String username;
	private String password;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String nombreCompleto;
	private String tipoUsuario;
	private String estadoUsuario;
	private String token;
	private List<PropiedadHorizontalDTO> propiedades;
}
