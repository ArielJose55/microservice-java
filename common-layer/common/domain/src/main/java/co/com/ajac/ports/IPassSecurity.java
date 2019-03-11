package co.com.ajac.ports;

public interface IPassSecurity {

	public boolean compare(String pass, String hash);
	
	public String cryptPass(String pass);
}
