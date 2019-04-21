package co.com.ajac.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryUsePrivateProperty {

	private Integer id;
	
	private LocalDateTime startDate;
	
	private LocalDateTime finishDate;
	
	private String identification;
	
	private Integer idPrivateProperty;
}
