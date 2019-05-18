package co.com.ajac;

public interface Command <R, C>{
	R excute (C command);
}
