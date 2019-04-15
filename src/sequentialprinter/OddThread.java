package sequentialprinter;

public class OddThread extends Thread {
	//add monitor here
	private final OddEvenMonitor monitor;
	public OddThread(OddEvenMonitor monitor){
		//set monitor here
		this.monitor = monitor;
	}

	@Override
	public void run() {
		for(int i = 1; i <= 100 ; i+= 2) {
			monitor.waitTurn(OddEvenMonitor.ODD_TURN);
			System.out.println(i); //my turn to print!
			try {
				sleep((int)(Math.random() * 100));
			} catch (InterruptedException e) {
			}
			monitor.yieldTurn();
		}
	}
}

