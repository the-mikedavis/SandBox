import java.util.*;
import java.io.*;
public class IntToCharConversion{
	public static void main(String[] args) throws FileNotFoundException{
		PrintStream printer = new PrintStream(new File("IntToChar.txt"));
		int[] integers = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
			21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46};
		for (int i : integers)
			printer.println("("+i+" + '7') = "+(char)(i + '7'));
		System.out.println("Done.");
	}
}