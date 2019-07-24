package co.com.ajac.events;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.vavr.control.Option;
import io.vavr.control.Try;

public interface Consumer {

	void onReceiver(String message);
	
	default <T> Option<T> convertir(ObjectMapper objectMapper, String eventString, Class<T> clase) {
		return Try.of(() -> objectMapper.readValue(eventString, clase))
				.toOption();	
	}
}
