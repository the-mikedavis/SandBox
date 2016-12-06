import java.util.Scanner;

public class Recursion{
  public static void main(String[] args){
    Scanner console = new Scanner(System.in);
    String entry;
    while(true){
      System.out.println();
      recur(console.nextInt());
    }
  }

  public static void recur(int n){
    System.out.print(n + " ");
    if (n % 2 == 0)
      recur(n/2);
    else if (n > 1)
      recur(3*n+1);
  }
}
