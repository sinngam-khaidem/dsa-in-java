import java.util.ArrayDeque;

public class QueueDemo{
	public static void main(String[] args){
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();

		// Enqueue elements to the queue
		q.add(10);
		q.add(20);
		q.add(30);
		q.add(40);
		q.add(50);

		System.out.println("Contents of the queue: " + q);

		System.out.println("Dequeue from the queue: " + q.remove());

		System.out.println("Contents of the queue: " + q);

		System.out.println("Is the queue empty? " + q.isEmpty());

		System.out.println("Size of the queue: " + q.size());

		// Peek the first element of the queue
		System.out.println("First element of the queue: "  + q.peekFirst());

		// Peek the last element of the queue
		System.out.println("Last element of the queue: " + q.peekLast());
	}
}