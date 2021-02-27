package secondExample;

import org.junit.jupiter.api.Test;
import secondSample.ClassWithSharedData;
import secondSample.FirstThread;
import secondSample.SecondThread;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SecondExampleTest {

	@Test
	public void volatileDataSharingTest() throws InterruptedException {
		ClassWithSharedData sharedData = new ClassWithSharedData();
		Thread thread1 = new Thread(new FirstThread(sharedData));
		Thread thread2 = new Thread(new SecondThread(sharedData));

		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();

		assertNotEquals(2000, sharedData.volatilePrimitiveNumber);
		System.out.printf("Primitive volatile int must be 2000 but it was %d %n", sharedData.volatilePrimitiveNumber);
		assertNotEquals(2000, sharedData.volatileObjectNumber);
		System.out.printf("Object volatile int must be 2000 but it was %d %n", sharedData.volatileObjectNumber);
		assertNotEquals(2000, sharedData.primitiveNumber);
		System.out.printf("Primitive int must be 2000 but it will be 1000 field value - %d %n", sharedData.primitiveNumber);
	}
}
