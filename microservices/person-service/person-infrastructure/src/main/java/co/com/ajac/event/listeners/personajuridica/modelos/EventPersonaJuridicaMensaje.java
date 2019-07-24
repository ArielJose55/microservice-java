package co.com.ajac.event.listeners.personajuridica.modelos;

import co.com.ajac.events.EventoMensaje;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventPersonaJuridicaMensaje  implements EventoMensaje {
	private String nit;
	private String razonSocial;
	private String objetoSocial;
}