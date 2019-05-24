package co.com.ajac.http.communicator;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Patterns.$Failure;
import static io.vavr.Patterns.$Success;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ajac.ports.PropertyCommunicator;
import infrastructure.http.Communicator;
import io.vavr.control.Option;
import io.vavr.control.Try;

@Component
public class PropertyHttpCommunicator implements Communicator, PropertyCommunicator{

	private static final String API_PROPERTY_SERVICE = "http://gateway-service:8000/property/commons/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public Option<Integer> findCommonPropertyWithThisId(Integer code) {
		
		Option<String> idOption = Try.ofCallable(() -> String.valueOf(code)).toOption();
		
		return idOption.fold(Option::none,
				idCommon -> {
					Option<String> body = getBodyOfRequestGet(restTemplate, API_PROPERTY_SERVICE, idCommon);
					
					if(body.isDefined()) {
						
						Try<Integer> identificationResult = Try.ofCallable(() -> mapper.readTree(body.get()).path("id").asInt());
						
						return Match(identificationResult).of(
								Case($Success($()),  Option::of),
								Case($Failure($()),  Option::none)
								);
					}
					
					return Option.none();
				});
	}

	
}
