package secondSample;

public class SecondThread implements Runnable {
	private final ClassWithSharedData sharedData;

	public SecondThread(ClassWithSharedData sharedData) {
		this.sharedData = sharedData;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			sharedData.volatileObjectNumber = sharedData.volatileObjectNumber + 1;
			sharedData.volatilePrimitiveNumber = sharedData.volatilePrimitiveNumber + 1;
		}
	}
}
