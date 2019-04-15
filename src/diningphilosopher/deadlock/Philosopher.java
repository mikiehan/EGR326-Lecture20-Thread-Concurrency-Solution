package diningphilosopher.deadlock;

public class Philosopher extends Thread {
	private int bites = 100;
	private Chopstick leftStick, rightStick;
	private int ID; //for printing philosopher's ID
	
    public Philosopher(Chopstick left, Chopstick right, int id) {
    	this.leftStick = left;
    	this.rightStick = right; 
    	this.ID = id;
    }
    
    public void eat(){
    	pickUp();
	    chew();
	    putDown();
    }

    public void putDown() {
    	//Implement putDown chopsticks
    	leftStick.putDown(ID, "left");
    	rightStick.putDown(ID, "right");
    	System.out.println("Philosopher " + ID + ": I done eating ... ");
    	System.out.flush();
    }
    
    public void pickUp(){
    	//Implement pickUp chopsticks
    	leftStick.pickUp(ID, "left");
    	rightStick.pickUp(ID, "right");
    	System.out.println("Philosopher " + ID + ": I have both chopsticks ... ");
    	System.out.flush();
    }
    
    public void chew() {
    	System.out.println("Philosopher " + ID + ": I am chewing YUM... ");
    	System.out.flush();
    	try {
            sleep((int)(Math.random() * 500));
        } catch (InterruptedException e) {
        }
    }
    
    public void think() {
    	System.out.println("Philosopher " + ID + ": I am thinking ... ");
    	System.out.flush();
    }
    
    
    
    public void run() {
    	for(int i = 0 ; i < bites ; i++) {
    		think();
    		eat();    		
    	}
    }
}