package runnableApp;

//synchronize cara 1
//public class ThreadMy extends Thread{
//	private SyncThread st;
//	public ThreadMy(String name, SyncThread s) {
//		super(name);
//		this.st = s;
//	}
//	public void run() {
//		//for (int i = 0; i<100; i++) {
//			System.out.println(Thread.currentThread().getName());
//			st.printList();
//		//}
//	}
//}

//synchronize cara 2

public class ThreadMy extends Thread{
	
	private String[] keranAir; //Data yang di share ke semua Thread
	
	public ThreadMy(String name, String[] keranAir) {
		super(name); // Memberikan nama ke Thread
		this.keranAir = keranAir; // set data yang akan dishare
	}
	public void run() {
		printData();
	}
	private void printData() {
		synchronized(keranAir){
		// Merubah data String dengan nama Thread yang sedang mengakses data
		//data.concat( Thread.currentThread().getName());
		keranAir[0] = Thread.currentThread().getName() + "keran 1";//(data[0]);
		keranAir[1] = Thread.currentThread().getName() + "keran 2";
		//cetak data
		System.out.println(keranAir[0]);
		System.out.println(keranAir[1]);
	}
	}
}