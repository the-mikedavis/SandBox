import java.util.Scanner;
public class MultipleObjectThreads implements Runnable{
    private int objectNumber;
    public static void main(String[] args){
        int maxObjects = 3000;

        int nObjects;
        try{
            nObjects = Integer.parseInt(args[0]);
        } catch (ArrayIndexOutOfBoundsException a) {
            nObjects = 0;
        }
        Scanner console = new Scanner(System.in);
        while (nObjects < 1 || nObjects > maxObjects){
            System.out.print(
"How many objects? (Please enter a number between 1 and "+maxObjects+"): ");
            try{
                nObjects = console.nextInt();
            } catch (NumberFormatException e){
                System.out.println("Please enter a number.");
                nObjects = 0;
            }
        }
        System.out.println("There are "+nObjects+" objects: ");
        MultipleObjectThreads[] objectArray =
            new MultipleObjectThreads[nObjects];
        Thread[] threads = new Thread[nObjects];
        for (int i = 0; i < nObjects; i++){
            objectArray[i] = new MultipleObjectThreads(i+1);
            threads[i] = new Thread(objectArray[i]);
            threads[i].start();
        }
    }

    public MultipleObjectThreads(int objectNumber){
        this.objectNumber = objectNumber;
    }

    @Override
    public void run(){
        System.out.printf("Object %4d is running on thread ID: %4d%n",
            this.getObjectNumber(), Thread.currentThread().getId());
    }

    public int getObjectNumber(){
        return objectNumber;
    }
}
