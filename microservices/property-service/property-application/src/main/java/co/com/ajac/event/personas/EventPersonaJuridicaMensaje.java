package co.com.ajac.event.personas;

import coremodel.persona.personanatural.Identificacion;
import events.EventoMensaje;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EventPersonaJuridicaMensaje implements EventoMensaje{
	
	private final Identificacion identificacion;
	
	private final String razonSocial;
	
	private final String objetoSocial;
	
}
