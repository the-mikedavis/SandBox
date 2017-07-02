import java.util.Scanner;
//attempts to safely ask the user for a number
public class SafeNumberScan{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        String response;
        int numeral = 1;
        do{
            System.out.print(numeral >= 0 ? "Enter a number: " : "Try again: ");
            response = console.nextLine();
            try{
                numeral = Integer.parseInt(response);
            } catch (NumberFormatException e) {
                numeral = -1;
            }
        } while (numeral != 0);
    }
}
