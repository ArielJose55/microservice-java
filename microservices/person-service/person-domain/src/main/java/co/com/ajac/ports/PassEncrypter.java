package co.com.ajac.ports;

public interface PassEncrypter {
	
	public String encrypt(String password);
	
	public String decrypt(String hash);
}
