package co.com.ajac.models.residents;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation {

	private Integer id;
	
	private String description;
	
	private String answer;
	
	private String state;
	
	private LocalDateTime startDate;
	
	private LocalDateTime finishDate;
	
	private Integer bienComun;
	
	private String identification;
}
