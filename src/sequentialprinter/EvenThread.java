package sequentialprinter;

public class EvenThread extends Thread {
	private final OddEvenMonitor monitor;

	public EvenThread(OddEvenMonitor monitor){
		this.monitor = monitor;
	}

	@Override
	public void run() {
		for(int i = 2 ; i <= 100 ; i+=2) {
			monitor.waitTurn(OddEvenMonitor.EVEN_TURN);
			System.out.println(i); //my turn to print!
			try {
				sleep((int)(Math.random() * 100));
			} catch (InterruptedException e) {
			}
			monitor.yieldTurn();
		}
	}
}
