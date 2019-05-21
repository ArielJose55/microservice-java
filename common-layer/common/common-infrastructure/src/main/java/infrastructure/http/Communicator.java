package infrastructure.http;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Patterns.$Failure;
import static io.vavr.Patterns.$Success;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import io.vavr.control.Option;
import io.vavr.control.Try;

public interface Communicator {

	default Option<String> getBodyOfRequestGet(RestTemplate restTemplate, String uri, String key){
		Try<ResponseEntity<String>> tryResponse = Try.ofCallable(() -> restTemplate.getForEntity(uri + key, String.class));
		
		return  Match(tryResponse).of(
				Case($Success($()), response -> Option.when(response.getStatusCode().is2xxSuccessful(), () -> response.getBody())),
				Case($Failure($()), Option.none())
				);
	}
	
	default <T> Option<String> getBodyOfRequestPost(RestTemplate restTemplate, String url, T  entity){
		HttpEntity<T> request = new HttpEntity<>(entity);
		
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
