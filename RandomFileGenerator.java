import java.util.*;
import java.io.*;

public class RandomFileGenerator{
    public static void main(String[] args) throws FileNotFoundException{
        Random generator = new Random();
        int random;
        File output = new File("RandomFile.txt");
        PrintStream printer = new PrintStream(output);
        for (int count = 0; count < 100; count++){
            random = generator.nextInt(100);
            printer.print(random + " ");
        }
    }
}
