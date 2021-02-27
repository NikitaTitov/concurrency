package firstSample;

public class FromRunnable implements Runnable{
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			System.out.printf("Hi I'm thread from class %s %n", this.getClass().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
