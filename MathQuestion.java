import java.util.*;
public class MathQuestion{
	public static void main(String[] args){
		System.out.println("Math.pow(2.0,3.0) = " + Math.pow(2.0,3.0));
		System.out.println("Math.sqrt(25.0) = " + Math.sqrt(25.0));
		System.out.println("Math.max(6,2) = " + Math.max(6,2));
		System.out.println("Math.max(-50.0,7.0) = " + Math.max(-50.0,7.0));
		System.out.println("Math.random() = " + Math.random());

		randomStudy();
	}
	public static void randomStudy(){
		double min = 11.0;
		double max = -1.0;
		int total = 0;

		for (int i = 0; i < 1000; i++){
			int randomInt = (int)(11.0 * Math.random());
			total = total + randomInt;
			if (randomInt > max){
				max = randomInt;
			}
			else if (randomInt < min){
				min = randomInt;
			}
		}

		System.out.println("Min value:" + min);
        System.out.println("Max Value:" + max);
        System.out.println("Average:"+ total / 1000d);
	}
}