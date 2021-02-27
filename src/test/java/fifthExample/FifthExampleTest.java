package fifthExample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

public class FifthExampleTest {

	ExecutorService executor;
	ClassFromCallable callable;

	@BeforeEach
	public void init() {
		callable = new ClassFromCallable();
		executor = Executors.newFixedThreadPool(10);
	}

	@Test
	public void runCallableThoughtFuture() throws ExecutionException, InterruptedException {
		Future<Integer> future = executor.submit(callable);
		assertFalse(future.isDone());
		assertEquals(10, future.get());
		assertTrue(future.isDone());
	}
}
