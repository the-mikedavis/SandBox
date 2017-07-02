import java.util.Random;
public class SwitchTest{
    public static void main(String[] args){
        Random generator = new Random();
        int random;
        for (int i = 0; i < 5; i++){
            random = generator.nextInt(5);
            System.out.println("The random is "+random);
            switch(random){
                case 0 : System.out.println("0");
                case 1 :
                case 2 : System.out.println("1 or 2"); break;
                case 3 :
                case 4 :
                default : System.out.println("3, 4, or else"); break;
            }
        }
    }
}
