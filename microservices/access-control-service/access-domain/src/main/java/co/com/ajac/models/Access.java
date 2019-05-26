package co.com.ajac.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Access {

	protected Integer commonProperty;
	
	protected String serial;
	
	protected Integer codeDevice;
	
	protected LocalDateTime dataEvent;
	
	protected AccessType type;
	
	protected AccessState state;
	
}
