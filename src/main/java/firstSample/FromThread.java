package firstSample;

public class FromThread extends Thread{
	@Override
	public void run() {
		System.out.printf("Hi I'm thread from class %s %n", this.getClass().getName());
	}
}
