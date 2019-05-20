package co.com.ajac.http.communicator;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ajac.ports.PersonCommunicator;
import coremodel.LegalPerson;
import io.vavr.control.Option;
import io.vavr.control.Try;

@Component
public class PersonHttpCommunicator implements PersonCommunicator{

	private static final String URI_PERSON = "http://gateway-service:8000/person/legalperson/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public Option<Integer> registerLegalPerson(LegalPerson property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Option<Integer> getIdProperty(String identification, String type) {
		
		HttpHeaders headers = new HttpHeaders();
		 
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        headers.setContentType(MediaType.APPLICATION_JSON);
 
        HttpEntity<String> entity = new HttpEntity<>(headers);
		
		ResponseEntity<String> response = restTemplate.exchange(URI_PERSON + identification, HttpMethod.GET, entity, String.class);
		System.out.println(response.getStatusCode());
		
		//Option<String> propertyJson = Option.when(response.getStatusCode().equals(HttpStatus.OK), response.getBody());
		
	//System.out.println(propertyJson);
		return Option.some(1);	
	}
	
	
}
