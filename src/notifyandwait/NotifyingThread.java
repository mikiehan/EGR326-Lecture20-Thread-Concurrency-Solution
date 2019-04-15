package notifyandwait;

class NotifyingThread extends Thread{
    int total;
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<100 ; i++){
                total += i;
                try {
    				sleep((int)(Math.random() * 100));
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            }            
            notify();
            System.out.println("Done calculating total and notifying");
        }
    }
}
