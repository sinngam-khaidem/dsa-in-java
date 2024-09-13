import java.util.ArrayList;

public class ArrayListDemo{
	public static void main(String[] args){
		ArrayList<Integer> al = new ArrayList<Integer>();

		// Adding elements to an array list
		al.add(1);
		al.add(25);
		al.add(3);
		al.add(4);
		al.add(5);
		al.add(2, -9999);
		System.out.println("Contents of the array list are: " + al);

		// Checking size of an array list
		System.out.println("Size of the array list: " + al.size());


		// Checking if an array list is empty
		System.out.println("Is the array list empty?: " + al.isEmpty());

		// Iterating through an ArrayList
		for(Integer x: al){
			System.out.print(x + " ");
		}
		System.out.print("\n");

		// Iterating through an ArrayList
		for(int i=0; i<al.size(); i++){
			System.out.print(al.get(i) + " ");
		}
		System.out.print("\n");

		
		// Remove last element of an array list
		al.remove(al.size() - 1);
		System.out.println("Contents of the array list are: " + al);

		// Remove all the elements of the array list
		al.removeAll(al);
		System.out.println("Is the array list empty?: " + al.isEmpty());

	}
}