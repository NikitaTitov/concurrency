package thirdExample;

public class SynchronizedClass {
	private int number;
	private final Object lock = new Object();

	public int getNumber() {
		return number;
	}

	public synchronized void synchronizedUpdateValue() {
		number++;
	}

	public void updateValue() {
		number++;
	}

	public void synchronizedOnObjectUpdateValue() {
		synchronized (lock) {
			number++;
		}
	}
}
