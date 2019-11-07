package thread;


	public class TestThread{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	TestThreadApp thr = new TestThreadApp();
	// thread ga selalu jalan berurutan
	thr.start();
	System.out.println("abc");
	}
	}

