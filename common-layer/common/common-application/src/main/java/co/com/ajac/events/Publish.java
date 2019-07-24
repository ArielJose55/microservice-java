package co.com.ajac.events;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.vavr.control.Option;
import io.vavr.control.Try;

public interface Publish {
	
	EventoMensaje onMessage(EventoMensaje eventoMensaje);
	
	default Option<String> convertir(ObjectMapper objectMapper, EventoMensaje eventoMensaje) {
		return Try.of(() -> objectMapper.writeValueAsString(eventoMensaje))
				.toOption();
	}
}
