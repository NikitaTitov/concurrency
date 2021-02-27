package fourthExample;

public class SubscriberOnSimpleObject implements Runnable {
	private final SimpleClassWithData simpleClassWithData;

	public SubscriberOnSimpleObject(SimpleClassWithData simpleClassWithData) {
		this.simpleClassWithData = simpleClassWithData;
	}

	@Override
	public void run() {
		synchronized (simpleClassWithData) {
			try {
				simpleClassWithData.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			simpleClassWithData.setMessage("Notified!!!");
		}
	}
}
