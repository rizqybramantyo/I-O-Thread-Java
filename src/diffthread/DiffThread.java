package diffthread;

class Sepatu{
	String status;
}

class Outsole extends Thread{
	private Sepatu sepatu;
	public Outsole(String name, Sepatu sepatu) {
		super(name);
		this.sepatu = sepatu;
	}
	public void run() {
		synchronized(sepatu) {
			sepatu.status = "Outsole Terpasang";
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sepatu.notify();
	}
}

class Emboss extends Thread{
		private Sepatu sepatu;
		public Emboss(String name, Sepatu sepatu) {
			super(name);
			this.sepatu = sepatu;
		}
		public void run() {
			try {
				sepatu.wait();	
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
			synchronized(sepatu) {
				sepatu.status += " Embossed";
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
}

class Joiner extends Thread{
	private Sepatu sepatu;
	public Joiner(String name, Sepatu sepatu) {
		super(name);
		this.sepatu = sepatu;
	}
	public void run() {
		try {
			sepatu.wait();	
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		synchronized(sepatu) {
			sepatu.status += " Joined";
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(sepatu.status);
			}
		}
	}

}

public class DiffThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sepatu sepatu = new Sepatu();
		Outsole outsole = new Outsole("Outsole", sepatu);
		Emboss emboss = new Emboss("Emboss", sepatu);
		Joiner joiner = new Joiner("Joiner", sepatu);
		
		outsole.start();
		emboss.start();
		joiner.start();
	}

}
