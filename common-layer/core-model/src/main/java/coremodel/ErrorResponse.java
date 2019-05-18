package coremodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Class to encapsulate domain errors
 * 
 * @author ariel.arnedo
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse implements Model{
	
	private Integer code;
	private String message;
	private boolean solvable;
	private String solvableDescription;
	/**
	 * @param code
	 * @param message
	 */
	public ErrorResponse(Integer code, String message) {
		this.solvable = false;
		this.solvableDescription = "";
		this.code = code;
		this.message = message;
	}
}
