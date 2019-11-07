package runnableApp;

public class TestRunnable implements Runnable {
	public void run() {
		for (int i = 0; i<100; i++) {
			System.out.println("i=" + i);
		}
	}
}
