package co.com.ajac.infrastructure.acl.communicator;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.vavr.collection.List;
import io.vavr.control.Option;
import io.vavr.control.Try;

public interface Communicator {

	default <T> Option<T> getApi(ObjectMapper objectMapper, RestTemplate restTemplate, String url, Class<T> clase) {
		return Try.of(() -> objectMapper.readValue(restTemplate.getForObject(url, String.class), clase)).toOption();
	}

	@SuppressWarnings("unchecked")
	default <T> List<T> getApiList(ObjectMapper objectMapper, RestTemplate restTemplate, String url, Class<T> clase) {

		try {
			Object readValue = objectMapper.readValue(
					restTemplate.getForObject(url, String.class),
					objectMapper.getTypeFactory().constructCollectionType(java.util.List.class, clase));
			java.util.List<T> lista =(java.util.List<T>) readValue;
			return List.ofAll(lista);
		} catch (RestClientException | IOException e) {
			e.printStackTrace();
		}
		
//		return Try.of(() -> (Class<T[]>) Class.forName("[L" + clase.getName() + ";"))
//			.mapTry(arrayClass -> objectMapper.readValue(
//				restTemplate.getForObject(url, String.class),
//				arrayClass))
//			.map(List::of)
//			.getOrElseThrow(() -> new IllegalAccessError("No se pudo deserializar el rest"));
		
		return List.empty();
		
	}

	default <T, E> Option<T> postApi(RestTemplate restTemplate, String url, Class<T> clase, E entity) {
		final HttpEntity<E> request = new HttpEntity<>(entity);
		return Try.of(() -> restTemplate.exchange(url, HttpMethod.POST, request, clase)).peek(System.err::println)
				.map(ResponseEntity::getBody).toOption();
	}

}
