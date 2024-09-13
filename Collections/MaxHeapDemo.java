import java.util.PriorityQueue;
import java.util.Collections;

public class MaxHeapDemo{
	public static void main(String[] args){
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int arr[] = {1,20,12, -5, 9999,2,8};

		for(int x: arr){
			pq.add(x);
		}

		System.out.println("Remove elements of the priority queue: ");
		while (pq.isEmpty() == false){
			System.out.println(pq.remove());
		}
	}
}