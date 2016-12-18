import java.util.Scanner;
//this class tests the Xor function "^" of Java
public class Xor{
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		String blank;
		boolean bool = true;
		System.out.println("Press RETURN to change the value of the boolean.");
		System.out.println("Enter 'q' to quit.");
		do{
			System.out.println("The value of the boolean is: "+bool);
			blank = console.nextLine();
			if (blank.length() == 0)
				blank = " ";
			bool ^= true;
			//This is the Xor operator. 
			//It switches the value of the boolean from t to f and f to t
		} while(blank.charAt(0) != 'q');
	}
}