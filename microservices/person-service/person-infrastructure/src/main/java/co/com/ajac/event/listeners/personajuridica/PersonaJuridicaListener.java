package co.com.ajac.event.listeners.personajuridica;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ajac.domain.exceptions.TechnicalException;
import co.com.ajac.event.configuration.AppPersonConfig;
import co.com.ajac.event.listeners.personajuridica.modelos.EventPersonaJuridicaMensaje;
import co.com.ajac.event.listeners.personajuridica.modelos.PersonaJuridicaEventBuilder;
import co.com.ajac.events.Consumer;
import co.com.ajac.services.PersonaJuridicaService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class PersonaJuridicaListener implements Consumer {

	private final ObjectMapper objectMapper;
	private final PersonaJuridicaService personaJuridicaService;

	@Autowired
	public PersonaJuridicaListener(ObjectMapper objectMapper, PersonaJuridicaService personaJuridicaService) {
		this.objectMapper = objectMapper;
		this.personaJuridicaService = personaJuridicaService;
	}



	@RabbitListener(queues = { AppPersonConfig.EXCHANGE_PROPERTY })
	public void onReceiver(String eventString) {

		EventPersonaJuridicaMensaje eventPersonaJuridicaMensaje = convertir(objectMapper, eventString,
				EventPersonaJuridicaMensaje.class)
						.getOrElseThrow(() -> new TechnicalException("Error al leer el evento: " + eventString));

		log.debug("Evento recibido con exito: {}", eventPersonaJuridicaMensaje);
		
		personaJuridicaService.guardarPersonaJuridica(
				PersonaJuridicaEventBuilder.crearPersonaJuridicaDesdeEvent(eventPersonaJuridicaMensaje));
	}
}
