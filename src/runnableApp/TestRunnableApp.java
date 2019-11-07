package runnableApp;

import thread.TestThreadApp;

public class TestRunnableApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//cara 1
		//SyncThread st = new SyncThread();
		//ThreadMy t1 = new ThreadMy("Thread 1", st);
		//ThreadMy t2 = new ThreadMy("Thread 2", st);
		//ThreadMy t3 = new ThreadMy("Thread 3", st);
		//ThreadMy t4 = new ThreadMy("Thread 4", st);
		
		//t1.start();
		//t2.start();
		//t3.start();
		//t4.start();
		
		//cara2
		String[] keranAir = {"Test", "Test1"};
		ThreadMy t1 = new ThreadMy("Orang 1", keranAir);
		ThreadMy t2 = new ThreadMy("Orang 2", keranAir);
		t1.start();
		t2.start();
	}

}
