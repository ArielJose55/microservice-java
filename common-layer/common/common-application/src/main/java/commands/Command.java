package commands;

public interface Command <M>{
	public void execute(M model);
}
