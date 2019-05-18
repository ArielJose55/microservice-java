package co.com.ajac.http.communicator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.com.ajac.ports.PropertyCommunicator;
import io.vavr.control.Option;

@Component
public class PropertyHttpCommunicator implements PropertyCommunicator{
	
	private final static String API_PROPERTY_SERVICE = "http:localhost:8081/property/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Option<Integer> checkExistenceProperty(Integer code, String property) {
		Map<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("id", code);
		ResponseEntity<Integer> forEntity = restTemplate.getForEntity(API_PROPERTY_SERVICE + "{id}", Integer.class, uriVariables);
		return Option.of(forEntity.getBody());
	}
}
