import java.util.HashMap;

public class HashMapDemo{
	public static void main(String[] args){
		HashMap<String, Integer> en = new HashMap<>();

		// Putting key value pairs in the hash map
		en.put("A", 1);
		en.put("B", 2);
		en.put("C", 3);

		// Get a set of all keys in the map
		System.out.println("The keys present in the map are: " + en.keySet());

		// Get values of elements in the map
		for(String x: en.keySet()){
			System.out.println(en.get(x));
		}

		// Check if a key is present in the Map
		System.out.println("Key \"A\" is present? : " + en.containsKey("A"));

		// Get the value corresponding to a key if present, else set the default value
		System.out.println("Value corresponding to key \"A\" if present: " + en.getOrDefault("A", 25));
	}
}