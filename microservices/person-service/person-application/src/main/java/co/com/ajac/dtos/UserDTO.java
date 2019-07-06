package co.com.ajac.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDTO {

	private String username;
	private String password;
	private String identification;
	private String token;
	private String names;
	private String lastName;
	private String completeName;
	private String role;
	
}
