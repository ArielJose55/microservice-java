package co.com.ajac.dtos;

import coremodel.datosbasicos.CorreoElectronico;
import coremodel.datosbasicos.Direccion;
import coremodel.datosbasicos.Telefono;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HabitanteDTO {

	private String numIdHabitante;
	private String tipoIdHabitante;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String nombreCompleto;
	private DatoBiometricoDTO datoBiometrico;
	private Direccion direccion;
	private CorreoElectronico correoElectronico;
	private Telefono telefono;
}
