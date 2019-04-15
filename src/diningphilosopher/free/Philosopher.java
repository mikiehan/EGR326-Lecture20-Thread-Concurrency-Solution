package diningphilosopher.free;

//Dead-lock free version! 

public class Philosopher extends Thread {
	private int bites = 5;
	private Chopstick leftStick, rightStick;
	private int ID;
	
    public Philosopher(Chopstick left, Chopstick right, int id) {
    	this.leftStick = left;
    	this.rightStick = right; 
    	this.ID = id;
    }
    
    public void eat(){
    	if(pickUp()){
	    	chew();
	    	putDown();
    	}
    }

    public boolean pickUp(){
    	if(!leftStick.pickUp(ID, "left")){
    		return false;
    	}
    	if(!rightStick.pickUp(ID, "right")){
    		leftStick.putDown(ID, "left");
    		return false;
    	}
    	System.out.println("Philosopher " + ID + ": I have both chopsticks ... ");
    	System.out.flush();
    	return true;
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
    	try {
            sleep((int)(Math.random() * 100));
        } catch (InterruptedException e) {
        }
    }
    
    public void putDown() {
    	leftStick.putDown(ID, "left");
    	rightStick.putDown(ID, "right");
    	System.out.println("Philosopher " + ID + ": I done eating ... ");
    	System.out.flush();
    }
    
    public void run() {
    	for(int i = 0 ; i < bites ; i++) {
    		think();
    		eat();    		
    	}
    }
}