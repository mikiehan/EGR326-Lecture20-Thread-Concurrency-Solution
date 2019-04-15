package diningphilosopher.deadlock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
	private Lock lock;
	
	public Chopstick() {
		lock = new ReentrantLock();
	}
	
	public void pickUp(int philosopherID, String side) {
		//grab lock here
		lock.lock();
		
		System.out.println("Philosopher "+ philosopherID + ": picked up " + side + " chopstick");
		System.out.flush();
	}

	public void putDown(int philosopherID, String side) {
		//release lock here
		lock.unlock();
		System.out.println("Philosopher "+ philosopherID + ": put down " + side + " chopstick");
		System.out.flush();
	}
}
