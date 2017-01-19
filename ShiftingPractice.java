import java.util.Scanner;
public class ShiftingPractice{
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		int number;
		try{
			number = Integer.parseInt(args[0]);
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.print("Enter the number to shift: ");
			number = console.nextInt();
		}
		for (int shift = 0; shift <= 5; shift++){
			System.out.println(number+" >> "+shift+" = "+(number >> shift));
		}
		for (int shift = 0; shift <= 5; shift++){
			System.out.println(number+" << "+shift+" = "+(number << shift));
		}
		for (int shift = 0; shift <= 5; shift++){
			System.out.println(number+" >>> "+shift+" = "+(number >>> shift));
		}
	}
}
/***
<< shifts the leftmost bit down. Will divide by 2 to the power of the shifter
>> shifts the leftmost bit up. Will multiply by 2 to the power of the shifter
>>> seems to do the same as >>
***/