import java.util.ArrayDeque;

public class StackDemo{
	public static void main(String[] args){
		ArrayDeque<Integer> st = new ArrayDeque<Integer>();

		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);

		System.out.println("Contents of the stack: " + st);

		System.out.println("Popping an element: " + st.pop());

		System.out.println("Contents of the stack: " + st);

		// Peek but do not remove the top of the stack
		System.out.println("Top of the stack is: " + st.peekFirst());

		System.out.println("Is the stack empty?" + st.isEmpty());

		System.out.println("Size of the stack: " + st.size());
	}
}