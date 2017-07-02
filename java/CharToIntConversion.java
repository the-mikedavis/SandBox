import java.util.*;
import java.io.*;
public class CharToIntConversion{
	public static void main(String[] args) throws FileNotFoundException{
		PrintStream printer = new PrintStream(new File("CharToInt.txt"));
		int[] digits = {0,1,2,3,4,5,6,7,8,9};
		char[] characters = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
			'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		//for (int d : digits) printer.println("("+d+" - '0') = "+(d - '0'));
		for (char c : characters)
			printer.println("("+c+" - '0') = "+(c - '0'));
		System.out.println("Done.");
	}
}