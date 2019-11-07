package latihanthread;

public class Loket extends Thread{
	private String[] loket;
	
	public Loket(String name, String[] loket) {
		super(name);
		this.loket = loket;
	}
	public void run() {
		printData();
	}
	private void printData() {
		synchronized(loket) {
			loket[0] = Thread.currentThread().getName() + "di loket Boarding Pass ";
			loket[1] = Thread.currentThread().getName() + "di pintu check in";
		
			System.out.println(loket[0]);
			System.out.println(loket[1]);
		}
	}
}
