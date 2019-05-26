package co.com.ajac.models;

import lombok.Getter;

@Getter
public enum AccessType {

	INPUT("IN"),
	OUTPUT("OUT");
	
	private final String alias;
	
	private AccessType(String alias) {
		this.alias = alias;
	}
}
