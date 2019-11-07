package latihanthread;

public class Main {
	public static void main(String[] args) {
		String[] loketBoardingPass = {"hoha", "hohe"};
		Loket l1 = new Loket("Penukar 1 ", loketBoardingPass);
		Loket l2 = new Loket("Penukar 2 ", loketBoardingPass);
		l1.start();
		l2.start();
	}
}
