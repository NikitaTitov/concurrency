package fifthExample;

import java.util.concurrent.Callable;

public class ClassFromCallable implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		Thread.sleep(3000);
		return 10;
	}
}
