package diningphilosopher.free;
//Dead-lock free version! 
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
	private Lock lock;
	
	public Chopstick() {
		lock = new ReentrantLock();
	}
	
	public boolean pickUp(int philosopherID, String side) {
		
		//return lock.tryLock();
		
		if(lock.tryLock()){
			System.out.println("Philosopher "+ philosopherID + ": picked up " + side + " chopstick");
			System.out.flush();
			return true;
		}
		else{
			System.out.println("Philosopher "+ philosopherID + ": could NOT pick up " + side + " chopstick");
			System.out.flush();
			return false;
		}
	}

	public void putDown(int philosopherID, String side) {
		lock.unlock();
		System.out.println("Philosopher "+ philosopherID + ": put down " + side + " chopstick");
		System.out.flush();
	}
}
