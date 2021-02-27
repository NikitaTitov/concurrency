package fourthExample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourthExampleTest {
	private Thread subscriber;
	private Thread emitter;
	private SimpleClassWithData simpleClassWithData;

	@BeforeEach
	public void init() {
		simpleClassWithData = new SimpleClassWithData();
		subscriber = new Thread(new SubscriberOnSimpleObject(simpleClassWithData));
		emitter = new Thread(new EmitterForSimpleClass(simpleClassWithData));
	}

	@Test
	public void objectWithNotify() throws InterruptedException {
		subscriber.start();
		emitter.start();

		subscriber.join();
		emitter.join();

		assertEquals("Notified!!!", simpleClassWithData.getMessage());
	}
}
