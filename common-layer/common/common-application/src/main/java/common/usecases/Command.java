package common.usecases;

public interface Command <C>{

	public void execute(C command );
}
