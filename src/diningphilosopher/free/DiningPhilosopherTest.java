package diningphilosopher.free;

import java.util.ArrayList;
//Dead-lock free version! 

public class DiningPhilosopherTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 5;
		ArrayList<Philosopher> philosophers = new ArrayList<Philosopher>();
		ArrayList<Chopstick> chopsticks = new ArrayList<Chopstick>();
		
		//create chopsticks
		for(int i = 0 ; i < num ; i++)
			chopsticks.add(new Chopstick());
		
		//create philosophers with chopsticks
		for(int i = 0 ; i < num - 1 ; i++) {
			philosophers.add(new Philosopher(chopsticks.get(i), chopsticks.get(i+1), i));
		}
		philosophers.add(new Philosopher(chopsticks.get(num-1), chopsticks.get(0), num-1));
		
		//Dining has started!
		for (int i = 0 ; i < num ; i++) {
		    philosophers.get(i).start();
		}
	}
}
