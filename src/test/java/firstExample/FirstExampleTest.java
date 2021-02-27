package firstExample;

import firstSample.FromRunnable;
import firstSample.FromThread;
import org.junit.jupiter.api.Test;

public class FirstExampleTest {

	@Test
	public void createThreads() throws InterruptedException {
		FromThread fromThread = new FromThread();

		FromRunnable fromRunnable = new FromRunnable();
		Thread threadFromRunnable = new Thread(fromRunnable);

		fromThread.start();
		threadFromRunnable.start();
		new Thread(() -> System.out.println("Hi I'm thread from Main class")).start();

		threadFromRunnable.join();
		System.out.println("Main method finished");
	}
}
