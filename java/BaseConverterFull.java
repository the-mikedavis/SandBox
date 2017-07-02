import java.util.Scanner;					//Scanner to prompt user
import java.util.InputMismatchException;	//To prevent scanner

/**
 * @author mcd
 */

public class BaseConverterFull {

	public final int MAXBASE = 36;			//More symbols could be used in theory however. This is 10 for digits and 26 for letters

	public static void main( String[] args ) {
		BaseConverterFull converter = new BaseConverterFull();	//class is made into an object for use down the line
		Scanner console = new Scanner( System.in );
		int baseTen = 0, startBase = 0, endBase = 0;
		String startNumber = "";
		System.out.println( "Welcome to the Base Converter! Maximum base supported is base " + converter.MAXBASE );
		do {
			System.out.print( "Enter a number (enter q to quit): " );
			startNumber = console.next();						//recieve the starting number as a string from the user
			if ( startNumber.startsWith( "b" ) || startNumber.startsWith( "q" ) )	//safe options for quitting in program, b for break
				break;
			startBase = converter.prompt( "input", console );	//recieve the starting base from the user
			baseTen = ( startBase == 10 ) ? Integer.parseInt( startNumber ) : converter.toBaseTen( startNumber, startBase );	//convert into base 10
			System.out.println( "In base ten this is: " + baseTen );	//display the result of the calculation
			endBase = converter.prompt( "output", console );			//recieve the ending base from the user
			System.out.println( "The new number is " + converter.toOtherBase( baseTen, endBase ) ); //display the final number
		} 	while ( baseTen != 0 );			//another safe breaking option, entering 0 for the original number
	}

	/** 
	* Returns an integer of a string number in a certain base converted into base 10.
	* Works by summing the numbers at each position times the base raised to the position.
	* The first segment of the equation converts characters into their integer components
	* by subtracting off a '0' or a '7' depending on whether or not (respectively) the 
	* character is a digit or a letter. Each character is converted into uppercase so that
	* the user may use 'a' or 'A' in high bases interchangeably - as is convention.
	* The second part of the equation is the base raised to the position of the character.
	* This is zero indexed, so the first exponent will be the string length minus one
	* and the final exponent summed will be 0. This summation converts all bases from base
	* 2 through base 36 into base ten.
	* @param	number		a number in base 2 to 36 in which A-Z are used as symbols 
	* 						following the digits from base 11 onward
	* @param	base		the base which the number is in
	* @return				the number converted into base 10
	*/
	public int toBaseTen( String number, int base ){
		int baseTen = 0;
		for ( int up = 0, down = number.length() - 1; up < number.length(); up++, down-- ){
			baseTen += ( number.toUpperCase().charAt( up ) - ( ( number.toUpperCase().charAt( up ) >= 'A' ) ? '7' : '0' ) ) * ( int ) Math.pow( base, down );
		}
		return baseTen;
	}

	/**
	* Returns a number in any base between 2 and 36, in which A-Z are used as symbols.
	* This equation works by dividing the based ten input number by the desired base. 
	* The remainder is prepended to a string (as you are decreasing orders of power,
	* and therefore have to work from the highest power to the lowest). The remainder
	* is converted to A for value 10, B for value 11 and so on up to Z : 35 by explicitly 
	* casting the integer into a character and then implicitly into a string. This while 
	* loop continues until the value of the input number decreases, asymtotically, to zero.
	* Since it's integer division, however, the while loop will terminate when the
	* division is less than 1.
	* @param	baseTen		a number in base ten
	* @param	newBase 	the desired outcome base
	* @return 				a string with the outcome number in the desired base
	*/
	public String toOtherBase( int baseTen, int newBase ){
		String newNumber = "";
		int digit;
		while ( baseTen > 0 ) {
			digit = baseTen % newBase;
			newNumber = ( ( digit >= 10 ) ? "" + (char) ( digit + '7' ) : digit ) + newNumber;
			baseTen /= newBase;
		}
		return newNumber;
	}

	/**
	* Prompts the user for a base, either input or output.
	* Rejects non-integer answers and any integer answers which
	* exceed the maximum accepted base or are less than or equal
	* to base 1. Repeatedly prompts the user until a valid base
	* is entered.
	* @param 	prompt 		either "input" or "output"
	* @param 	console 	a System.in scanner from the main method
	* @return 				the base which the number is or is to be in
	*/
	private int prompt( String prompt, Scanner console ) {
		int base = 0;
		do {
			System.out.print( "Enter an " + prompt + " base: " );
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

	/**
	* Prompts the user for a base, either input or output. 
	* Rejects non-integer answers and any integer answers which
	* exceed the maximum accepted base or are less than or equal
	* to base 1. Repeatedly prompts the user until a valid base is entered.
	* Overloaded form which doesn't have the scanner past through parameters.
	* @param	prompt 		either "input" or "output"
	* @return 				the base which the number is or is to be in
	*/
	private int prompt( String prompt ) {
		Scanner console = new Scanner( System.in );
		int base = 0;
		do {
			System.out.print( "Enter an " + prompt + " base: " );
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
