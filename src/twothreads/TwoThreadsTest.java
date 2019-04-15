package twothreads;

class TwoThreadsTest {

	public static void main(String[] args) {
		//uncomment below after implementing SimpleThread
		new SimpleThread("Jamaica").start();
		new SimpleThread("Fiji").start();
		new SimpleThread("Bora Bora").start();
	}


	//Implement SimpleThread
	private static class SimpleThread extends Thread {
		public SimpleThread(String name) {
			super(name);
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(i + " " + getName());
				try {
					sleep((int) (Math.random() * 1000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Final Choice: " + getName());
		}
	}
}