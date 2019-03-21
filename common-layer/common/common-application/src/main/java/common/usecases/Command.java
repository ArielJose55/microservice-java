package common.usecases;

public interface Command <C>{

	public boolean execute(C command );
}
