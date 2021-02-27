package secondSample;

public class FirstThread implements Runnable {
	private final ClassWithSharedData sharedData;

	public FirstThread(ClassWithSharedData sharedData) {
		this.sharedData = sharedData;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			sharedData.volatileObjectNumber++;
			sharedData.volatilePrimitiveNumber++;
			sharedData.primitiveNumber++;
		}
	}
}
