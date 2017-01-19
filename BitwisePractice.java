import java.util.Scanner;
public class BitwisePractice{
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		int entry, match = 2;
		System.out.println("The bitwise number is: "+match);
		do {
			try{
				entry = console.nextInt();
			} catch (NumberFormatException e){
				entry = 1;
			}
			System.out.println(match+" & "+entry+" = "+(match & entry));
		} while (entry >= 0);
	}
}
/***
Input : Ouput for match = 8
0 : 0
1 : 0
2 : 0
3 : 0
4 : 0
5 : 0
6 : 0
7 : 0
8 : 8
***/