import java.util.*;
public class Hanoi {
  static String[] names = { "L", "M", "R" };
  static void solve( int number, int fromPole, int toPole ) {
    if ( number == 1 ) {
      System.out.printf( "Move %d from %s to %s%n", number,
          names[ fromPole ], names[ toPole ] );
    }
    else {
      int remainder = 3 - fromPole - toPole;
      solve( number - 1, fromPole, remainder );
      System.out.printf( "Move %d from %s to %s%n", number,
          names[ fromPole ], names[ toPole ] );
      solve( number - 1, remainder, toPole );
    }
  }
  public static void main( String[] args ) {
    int argsInt;
    long startTime, endTime;
    Scanner console = new Scanner(System.in);
    try{
        argsInt = Integer.parseInt(args[0]);
    } catch (ArrayIndexOutOfBoundsException e){
        System.out.print("Enter a number of plates: ");
        argsInt = console.nextInt();
    }
    startTime = System.nanoTime();
    solve( argsInt, 0, 1 );
    endTime = System.nanoTime();
    long time = ((endTime - startTime)/100000000);
    System.out.println(
"The calculation lasted: "+time+" seconds.");
    System.out.println(
"There were "+((int)Math.pow(2, argsInt)-1)+" movements made.");
  }
}
