package common.usecases;

import java.util.Optional;

public interface Query < R , Q >{

	public Optional<R> execute(Q query);
}
