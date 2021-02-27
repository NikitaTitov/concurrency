package fourthExample;

public class EmitterForSimpleClass implements Runnable {
	private final SimpleClassWithData simpleClassWithData;

	public EmitterForSimpleClass(SimpleClassWithData simpleClassWithData) {
		this.simpleClassWithData = simpleClassWithData;
	}

	@Override
	public void run() {
		synchronized (simpleClassWithData) {
			try {
				simpleClassWithData.setMessage("In emitter");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			simpleClassWithData.notifyAll();
		}
	}
}
