package co.com.ajac.infrastructure.acl.configuration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

@Configuration
public class JacksonConfigurer {

	private static final String LOCAL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";
	private static final String LOCAL_DATE_FORMAT = "HH:mm";

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();

		JavaTimeModule javaTimeModule = new JavaTimeModule();

		SimpleModule module = new SimpleModule();
		
		ParameterNamesModule parameterNamesModule = new ParameterNamesModule();
		
		Jdk8Module jdk8Module = new Jdk8Module();

		module.addSerializer(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
			@Override
			public void serialize(LocalDateTime localDateTime, JsonGenerator generator, SerializerProvider provider)
					throws IOException {
				generator.writeString(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_FORMAT).format(localDateTime));
			}
		});

		module.addDeserializer(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
			@Override
			public LocalDateTime deserialize(JsonParser parser, DeserializationContext provider) throws IOException {
				return LocalDateTime.parse(parser.getText(), DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_FORMAT));
			}
		});
		
		module.addSerializer(LocalTime.class, new JsonSerializer<LocalTime>() {
			@Override
			public void serialize(LocalTime localDateTime, JsonGenerator generator, SerializerProvider provider)
					throws IOException {
				generator.writeString(DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT).format(localDateTime));
			}
		});

		module.addDeserializer(LocalTime.class, new JsonDeserializer<LocalTime>() {
			@Override
			public LocalTime deserialize(JsonParser parser, DeserializationContext provider) throws IOException {
				return LocalTime.parse(parser.getText(), DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT));
			}
		});

		objectMapper.registerModule(javaTimeModule);

		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		
		objectMapper.registerModule(module);
		
		objectMapper.registerModule(jdk8Module);
		
		objectMapper.registerModule(parameterNamesModule);

		return objectMapper;
	}
}
