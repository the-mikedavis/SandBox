

public class HashingWrite {
	public static void main(String[] args){
		for (Character c = '0'; c <= 'z'; c++)
			System.out.println(c +": "+ c.hashCode());
	}
}