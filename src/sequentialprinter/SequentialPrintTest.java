package sequentialprinter;

public class SequentialPrintTest {

	public static void main(String[] args) {
		OddEvenMonitor monitor = new OddEvenMonitor();
		OddThread t1 = new OddThread(monitor);
	    EvenThread t2 = new EvenThread(monitor);	
	    t1.start();
	    t2.start();
	}
}
