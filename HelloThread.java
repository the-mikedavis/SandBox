public class HelloThread implements Runnable{
	public static void main(String[] args){
		System.out.println("This is currently running on the main thread.");
		System.out.println("The ID is: " + Thread.currentThread().getId());
		HelloThread helloThread = new HelloThread();
		Thread thread = new Thread(helloThread);
		thread.start();
        run(5);
	}

	@Override
	public void run(){
		System.out.println("This is currently running on thread ID: "+
			Thread.currentThread().getId());
	}
    
    public static void run(int c){
        System.out.println("The static method is currently running on ID: "+Thread.currentThread().getId());
    }
}
