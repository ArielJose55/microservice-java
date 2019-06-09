package co.com.ajac.http.communicators;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Patterns.$Failure;
import static io.vavr.Patterns.$Success;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ajac.ports.DeviceCommunicator;
import infrastructure.http.Communicator;
import io.vavr.control.Option;
import io.vavr.control.Try;

@Component
public class DeviceHttpCommunicator implements DeviceCommunicator, Communicator{

	private static final String API_URI_PROPERTY_SERVICE = "http://gataway-service:8000/device/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public Option<Integer> verifyDeviceExistence(String serial) {
		
		Option<String> bodyOption = getBodyOfRequestGet(restTemplate, API_URI_PROPERTY_SERVICE, serial);
		
		return bodyOption.fold(Option::none,
				body -> {
					
					Try<Integer> identificationResult = Try.ofCallable(() -> mapper.readTree(body).path("id").asInt());
					
					return Match(identificationResult).of(
							Case($Success($()),  Option::of),
							Case($Failure($()),  Option::none)
							);
				});
	}

	
}
