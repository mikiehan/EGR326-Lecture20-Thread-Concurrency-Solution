package sequentialprinter;

public	class OddEvenMonitor{
	public static final int ODD_TURN = -1;
	public static final int EVEN_TURN = 1;

	private volatile int turn = ODD_TURN;

	public synchronized void waitTurn(int myTurn){
		while (turn != myTurn) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public synchronized void yieldTurn() {
		//if currently it is odd's turn then it will be even's turn
		//if currently it is even's turn then it will be odd's turn
		turn *= -1;
		notify();
	}
}
