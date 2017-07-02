import java.util.List;
import java.util.LinkedList;

    /**
    * @author mcd
    */
public class HashingMathProof {
    
    public static void main(String[] args){
        System.out.println(motor());
    }
    
    public static List<String> combine () {
        LinkedList<String> combinations = new LinkedList<String>();
        for (char c = 'a'; c <= 'z'; c++)
            for (char b = 'a'; b <= 'z'; b++)
                //for (char a = 'a'; a <= 'z'; a++)
                    combinations.add(c+""+b);
        return combinations;
    }
    
    public static boolean motor () {
        List<String> combinations = combine();
        for (String combination : combinations)
            for (int i = 0; i < combinations.size(); i++)
                if (!combination.equals(combinations.get(i)))
                    if (combination.hashCode() == combinations.get(i).hashCode())
                        return false;
        return true;
    }
}