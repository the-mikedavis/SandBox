import java.util.Scanner;

public class InsertionPractice{
	public static int size = 5;
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		int[] array = new int[20];
		for (int count = 0; count < 5; count++)
			array[count] = count;
		while(true){
			System.out.print("Enter an index to add to: ");
			addEntryStyle2(console.nextInt(), array);
			print(array);
		}
	}
	public static void removeEntry(int index, int[] array){
		if (index >= 0){
			int[] copy = new int[size-index-1];
			for (int count = 0; count < copy.length; count++){
				copy[count] = array[count+index+1];
			}
			for (int count = 0; count < copy.length; count++){
				array[index+count] = copy[count];
			}
		}
		--size;
	}

	public static void addEntry(int index, int[] array){
        if (index == size){
            array[size++] = index;
        }
		else if (index >= 0){
			int[] copy = new int[size-index];
			for (int count = 0; count < copy.length; count++)
				copy[count] = array[count+index];
			for (int count = 0; count < copy.length; count++)
				array[index+count+1] = copy[count];
            System.out.println("Index is "+index);
			array[index+1] = index;
            size++;
		}
	}
	public static void removeEntryStyle2(int value, int[] array){
		int index = fing(value, array);
		
	}
	public static void addEntryStyle2(int value, int[] array){
		int index = find(value, array);
		if (index == size)
			array[size++] = value;
		else if (index >= 0){
			for (int count = size; count > index; count--)
				array[count] = array[count-1];
			array[index+1] = value;
			size++;
		}
	}
	public static void print(int[] array){
		for (int index = 0; index < size; index++)
			System.out.println(array[index]);
	}
	public static int find(int value, int[] array){
		for (int count = 0; count < size; count++){
			if (array[count] > value){
				//System.out.println("Returning index "+count);
				return (count-1);
			}
		}
		return size;
	}
}
