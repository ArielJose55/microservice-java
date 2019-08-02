package co.com.ajac.infrastructure.http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource("classpath:ms-config.properties")
public class Configuracion {

	private final String basePackage = "co.com.ajac.enpoints";
	
	@Value("${ms-service.titulo}")
	private String titulo;
	
	@Value("${ms-service.descripcion}")
	private String descripcion;
	
	@Value("${ms-service.version}")
	private String version;
	
	@Value("${ms-service.autores}")
	private String autores;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(basePackage))
				.build().apiInfo(metaDate());
	}

	private ApiInfo metaDate() {
		return new ApiInfoBuilder()
				.title(titulo)
				.description(descripcion)
				.version(version)
				.contact(new Contact(autores, "", ""))
				.license("MIT").build();
	}

}
