package common;

public interface Query < R , Q > {
	public R execute(Q query);
}