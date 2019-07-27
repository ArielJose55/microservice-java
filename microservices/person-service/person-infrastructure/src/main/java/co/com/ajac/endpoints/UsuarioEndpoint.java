package co.com.ajac.endpoints;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.commands.RegistrarUsuarioCommand;
import co.com.ajac.dtos.UsuarioDTO;
import co.com.ajac.entities.usuarios.Credencial;
import co.com.ajac.queries.UsuarioQuery;
import coremodel.datosbasicos.Identificacion;

@RestController
@RequestMapping("/person/api/v1")
public class UsuarioEndpoint {
	
	private final RegistrarUsuarioCommand registrarUsuarioCommand;
	private final UsuarioQuery usuarioQuery;
	
	@Autowired
	public UsuarioEndpoint(RegistrarUsuarioCommand registrarUsuarioCommand, UsuarioQuery usuarioQuey) {
		this.registrarUsuarioCommand = registrarUsuarioCommand;
		this.usuarioQuery = usuarioQuey;
	}

	@PostMapping("/users")
	public void add(@Valid @RequestBody UsuarioDTO usuarioDTO) {
		registrarUsuarioCommand.execute(usuarioDTO);
	}
	
	@GetMapping("/users/{tipoId}/{numId}")
	public UsuarioDTO get(@PathVariable("tipoId") String tipoId, @PathVariable("numId") String numId) {
		
		return usuarioQuery.obtenerUsuarioPorSuIdentificacion(
				Identificacion.builder()
				.numeroIdentificacion(numId)
				.tipoIdentificacion(tipoId)
				.build());
	}
	
	@PostMapping("/users/login")
	public UsuarioDTO login(@RequestBody UsuarioDTO usuarioDTO) {
		return usuarioQuery.obtenerUsuarioPorSusCredenciales(
				Credencial.builder()
				.username(usuarioDTO.getUsername())
				.password(usuarioDTO.getPassword())
				.build());
	}
	

//	
//	@GetMapping("/ph/{id}")
//	public List<Usuario> getAll(@PathVariable("id") Integer idPh){
//		return null;
//	}
}
