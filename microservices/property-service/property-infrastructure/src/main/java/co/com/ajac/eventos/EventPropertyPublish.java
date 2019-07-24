package co.com.ajac.eventos;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ajac.domain.exceptions.TechnicalException;
import co.com.ajac.events.EventoMensaje;
import co.com.ajac.events.Publish;
import co.com.ajac.infrastructure.eventos.EventConf;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class EventPropertyPublish implements Publish {

	@Autowired
	private RabbitMessagingTemplate rabbitMessagingTemplate;

	@Autowired
	private EventConf eventConf;

	@Autowired
	private MappingJackson2MessageConverter mappingJackson2MessageConverter;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public EventoMensaje onMessage(EventoMensaje eventoMensaje) {

		rabbitMessagingTemplate.setMessageConverter(mappingJackson2MessageConverter);

		log.debug("Se inicia la publicacion del evento: {}", eventoMensaje);

		rabbitMessagingTemplate.convertAndSend(eventConf.getQueue(),
				convertir(objectMapper, eventoMensaje).getOrElseThrow(
						() -> new TechnicalException("Ocurrio un error al deserializar el evento: " + eventoMensaje)));

		log.debug("Evento publicado con exito: {}", eventoMensaje);

		return eventoMensaje;
	}

}
