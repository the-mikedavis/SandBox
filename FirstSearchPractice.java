import java.util.*;
import java.io.*;

public class FirstSearchPractice{
    public static int[] data;
    public static void main(String[] args) throws FileNotFoundException{
        Scanner fileScanner = new Scanner(new File("RandomFile.txt"));
        Scanner console = new Scanner(System.in);
        data = new int[101];
        for (int count = 0; fileScanner.hasNext(); count++){
            data[count] = fileScanner.nextInt();
        }
        Arrays.sort(data);
        System.out.print("Enter a value to search for: ");
        int searchForVal = console.nextInt();
        System.out.println("The index of the item is: "+
            search(searchForVal, 0, data.length));
    }
    public static int search(int val, int startIndex, int endIndex){
        int searchLocation = (endIndex - startIndex)/2 + startIndex;
        if (val == data[searchLocation])
            return searchLocation;
        else if (val < data[searchLocation])
            return search(val, startIndex, searchLocation);
        else // if (val > data[searchLocation])
            return search(val, searchLocation, endIndex);
    }
}
