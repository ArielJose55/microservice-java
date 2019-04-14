package co.com.ajac.ports;

public interface IPassEncrypter {
	
	public String encrypt(String password);
	
	public String decrypt(String hash);
}
