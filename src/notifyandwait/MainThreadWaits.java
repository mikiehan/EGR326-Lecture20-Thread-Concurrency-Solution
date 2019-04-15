package notifyandwait;

public class MainThreadWaits {
    public static void main(String[] args){
        NotifyingThread b = new NotifyingThread();
        b.start();
 
        synchronized(b){
            try{
                System.out.println("Waiting for b to complete...");
                b.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
 
            System.out.println("Total is: " + b.total);
        }
    }
}
