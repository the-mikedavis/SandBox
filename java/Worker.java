public class Worker implements Runnable {
  public static void main (String[] args){
    System.out.println("This is currently running on the main thread, " +
    		"the id is: " + Thread.currentThread().getId());
    Worker worker = new Worker(); 
    Thread thread = new Thread(worker);
    thread.start();
  }
  
  @Override
  public void run() {
    System.out.println("This is currently running on a separate thread, " +
    		"the id is: " + Thread.currentThread().getId()); 
  }
}