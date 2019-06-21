package co.com.ajac.dtos;

import javax.validation.constraints.NotBlank;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserDTO {

	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	public UserDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}
}
