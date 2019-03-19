package co.com.ajac.models;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistorialAccess {

	private static final String FECHA_DE_REGISTRO_NO_FUTURA = "La fecha de registro no tiene que ser posterior al día de hoy";

	private static final String FIELD_NOT_EMPLY = "Este campo no puede estar vacío";
	
	private static final String ID_MESSAGE_VALIDATE = "El numero de identificación debe tener una longitud de entre {min} y {max}  caracteres";
	
	@NotNull(message = FIELD_NOT_EMPLY)
	@PastOrPresent(message = FECHA_DE_REGISTRO_NO_FUTURA)
	private LocalDateTime registrationDate;
	
	@NotEmpty(message = FIELD_NOT_EMPLY)
	private String type;
	
	@NotNull(message = FIELD_NOT_EMPLY)
	private Integer device;
	
	@NotEmpty(message = FIELD_NOT_EMPLY)
	@Size(min = 5, max = 20, message = ID_MESSAGE_VALIDATE)
	private String identification;
}
