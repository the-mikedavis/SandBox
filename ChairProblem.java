//given a room full of chairs labeled 1 to 100, 
public class ChairProblem{
	public static void main(String[] args){
		int skipamount = 0;
		int position = 0;
		int[] array = new int[100];
		for (int i = 0; i < array.length; i++)
			array[i] = i+1;
		//[0] = 1, [1] = 2, ..., [99] = 100 This will give the seat number
		while(array.length > 1){
			System.out.println("Removing the person at chair "+array[position]+". Position is: "+position);
			array = remove(array, position + skipamount++);
			System.out.println("The new array length is: "+array.length);
			if (position >= array.length)
				position = position - array.length;
		}
		System.out.println("The survivor is at chair: "+array[0]);
	}
	public static int[] remove(int[] array, int position){
		int[] temp = new int[array.length-1];
		for (int count = 0; count < temp.length; count++){
			if (count < position)
				temp[count] = array[count];
			else if (count > position)
				temp[count] = array[count+1];
		}
		return temp;
	}
}