package thirdExample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ThirdExampleTest {

	private ExecutorService executorService;
	private SynchronizedClass synchronizedClass;

	@BeforeEach
	public void init() {
		executorService = Executors.newFixedThreadPool(10);
		synchronizedClass = new SynchronizedClass();
	}

	@Test
	public void nonSynchronizedMethodCall() throws InterruptedException {
		IntStream.range(0, 10000).forEach(value -> executorService.submit(synchronizedClass::updateValue));

		executorService.awaitTermination(10000, TimeUnit.MILLISECONDS);

		assertNotEquals(1000, synchronizedClass.getNumber());
		System.out.printf("%d not sync %n", synchronizedClass.getNumber());
	}

	@Test
	public void synchronizedMethodCall() throws InterruptedException {
		IntStream.range(0, 10000).forEach(value -> executorService.submit(synchronizedClass::synchronizedUpdateValue));

		executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);

		assertEquals(10000, synchronizedClass.getNumber());
		System.out.printf("%d sync on method %n", synchronizedClass.getNumber());
	}

	@Test
	public void synchronizedOnObjectMethodCall() throws InterruptedException {
		IntStream.range(0, 10000).forEach(value -> executorService.submit(synchronizedClass::synchronizedOnObjectUpdateValue));

		executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);

		assertEquals(10000, synchronizedClass.getNumber());
		System.out.printf("%d synced code block %n", synchronizedClass.getNumber());
	}
}
