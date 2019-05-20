package co.com.ajac.http.communicator;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Patterns.$Failure;
import static io.vavr.Patterns.$Success;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ajac.ports.PersonCommunicator;
import coremodel.LegalPerson;
import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class PersonHttpCommunicator implements PersonCommunicator{

	private static final String URI_PERSON = "http://gateway-service:8000/person/legalperson/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public Option<String> registerLegalPerson(LegalPerson property) {
		log.info("Peticion a microservicio de Person para registrar esta LegalPerson: {}", property);
		
		Option<String> body = getBodyOfRequestPost(URI_PERSON, property);
		
		log.debug("Resultado de la peticion: {}", body);
		
		if(body.isDefined()) {
			Try<String> identificationResult = Try.ofCallable(() -> mapper.readTree(body.get()).path("identification").asText());
			return Match(identificationResult).of(
					Case($Success($()),  Option::of),
					Case($Failure($()),  Option::none)
					);
		}
		return Option.none();
	}

	@Override
	public Option<String> getIdProperty(String identification, String type) {
		
		Option<String> body = getBodyOfRequestGet(URI_PERSON, identification);

		if(body.isDefined()) {
			Try<String> identificationResult = Try.ofCallable(() -> mapper.readTree(body.get()).path("identification").asText());
			return Match(identificationResult).of(
					Case($Success($()),  Option::of),
					Case($Failure($()),  Option::none)
					);
		}
		return Option.none();
	}
	
	private Option<String> getBodyOfRequestGet(String uri, String key){
		Try<ResponseEntity<String>> tryResponse = Try.ofCallable(() -> restTemplate.getForEntity(uri + key, String.class));
		
		return  Match(tryResponse).of(
				Case($Success($()), response -> Option.when(response.getStatusCode().is2xxSuccessful(), () -> response.getBody())),
				Case($Failure($()), Option.none())
				);
	}
	
	private Option<String> getBodyOfRequestPost(String url, LegalPerson  entity){
		HttpEntity<LegalPerson> request = new HttpEntity<>(entity);
		
		Try<ResponseEntity<String>> tryResponse = Try.ofCallable(() -> restTemplate.exchange(url, HttpMethod.POST, request, String.class));
		if(tryResponse.isFailure()) {
			System.out.println(tryResponse.getCause());
		}
		return  Match(tryResponse).of(
				Case($Success($()), response -> Option.when(response.getStatusCode().is2xxSuccessful(), () -> response.getBody())),
				Case($Failure($()), Option.none())
				);
	}
}
