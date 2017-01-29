import java.util.Scanner;

public class BinaryPractice{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        do{
            System.out.print("Enter a binary string: ");
            System.out.println(toDecimal(console.next()));
        } while(true);
    }
    static int toDecimal(String binary){
        int decimal = 0;
        int charInt;
        for (int count = binary.length()-1; count >= 0; count--){
            charInt = (int)binary.charAt(count);
            decimal += charInt*Math.pow(2, count);
        }
        return decimal;
    }
}
