import java.util.HashMap;
import java.util.Map.Entry;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 1, 2, 3, 5, 5, 2, 2, 2, 9, 9, 9 };

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			if (!map.containsKey(arr[i])) {

				map.put(arr[i], 1);

			}

			else {

				int temp = map.get(arr[i]);

				map.put(arr[i], temp + 1);

			}

		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {

			System.out.println(entry.getKey() + " : " + entry.getValue());

		}

	}

}
