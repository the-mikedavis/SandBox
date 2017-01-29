import java.util.Scanner;
import java.util.InputMismatchException;
public class BaseConverter{
	private static final int MAXBASE = 36;
	public static void main(String[] args){
		BaseConverter converter = new BaseConverter();
		Scanner console = new Scanner(System.in);
		int baseTen = 0, startBase = 0, endBase = 0;
		String startNumber = "";
		System.out.println("Welcome to the Base Converter! Maximum base supported is base "+MAXBASE);
		do{
			System.out.print("Enter a number: ");
			startNumber = console.next();
			if (startNumber.startsWith("b") || startNumber.startsWith("q"))
				break;
			startBase = converter.prompt("input", console);
			baseTen = (startBase == 10) ? Integer.parseInt(startNumber) : converter.toBaseTen(startNumber, startBase);
			System.out.println("In base ten this is: "+baseTen);
			endBase = converter.prompt("output", console);
			System.out.print("The new number is ");
			System.out.println(converter.toOtherBase(baseTen, endBase));
		} 	while(baseTen != 0);
	}
	public int toBaseTen(String s, int base){
		int baseTen = 0;
		for (int i = 0, j = s.length()-1; i < s.length(); i++, j--)
			baseTen += (s.toUpperCase().charAt(i) - ((s.toUpperCase().charAt(i) >= 'A') ? '7' : '0')) * (int)Math.pow(base, j);
		return baseTen;
	}
	public String toOtherBase(int baseTen, int newBase){
		String newNumber = "";
		int digit;
		while(baseTen > 0){
			digit = baseTen % newBase;
			newNumber = ((digit >= 10) ? ""+(digit+'7') : digit) + newNumber;
			baseTen /= newBase;
		}
		return newNumber;
	}
	public int prompt( String prompt, Scanner console ) {
		int base = 0;
		do {
			System.out.print( "Enter an "+prompt+" base: " );
			try{
				base = console.nextInt();
			} 	catch ( InputMismatchException e ) {
				System.out.println( "Please enter a valid base." );
				console.nextLine();
				base = 0;
			}
		} 	while( base <= 1 || base > MAXBASE );
		return base;
	}
}
