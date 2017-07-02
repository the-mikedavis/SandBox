import java.util.Scanner;
public class Tilt{
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		String[] t = {"---", " | ", " | "};
		String[] i = {"---", " | ", "---"};
		String[] l = {"|  ", "|  ", "---"};
		while(true){
		System.out.print("Enter a four letter word made out of T,I, and L: ");
		char[] input = console.next().toLowerCase().toCharArray();
		if (input[0] == 'q')
			break;
		String[] lines = new String[3*input.length];
		for (int count = 0; count < input.length; count++){
			switch(input[count]){
				case 't' :
					lines[count] = t[0];
					lines[count+input.length] = t[1];
					lines[count+input.length*2] = t[2];
					break;
				case 'i' : 
					lines[count] = i[0];
					lines[count+input.length] = i[1];
					lines[count+input.length*2] = i[2];
					break;
				case 'l' : 
					lines[count] = l[0];
					lines[count+input.length] = l[1];
					lines[count+input.length*2] = l[2];
					break;
				default : break;
			}
		}
		for (int count = 0; count < lines.length; count++){
			System.out.print(lines[count] + " ");
			if (count % input.length == input.length-1)
				System.out.println();
		}
	}
	}

}