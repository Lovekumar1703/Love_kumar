import java.util.HashMap;
import java.util.Map.Entry;

public class Rearrange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	System.out.println(reaaranged("b"));
		
		String s= "parss";
		String s2= "parss";
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		HashMap<Character, Integer> map2 = new HashMap<>();
		
	
		for (int i = 0; i < s.length(); i++) {

			if (!map.containsKey(s.charAt(i))) {

				map.put(s.charAt(i), 1);

			}

			else {

				int temp = map.get(s.charAt(i));

				map.put(s.charAt(i), temp + 1);

			}

		}

		for (int j = 0; j < s2.length(); j++) {

			if (!map2.containsKey(s2.charAt(j))) {

				map2.put(s2.charAt(j), 1);

			}

			else {

				int temp1 = map.get(s2.charAt(j));

				map2.put(s2.charAt(j), temp1 + 1);

			}

		}
		
	//System.out.println(map.entrySet().equals(map2.entrySet()));
//map.entrySet().equals(map2.entrySet())
		
	
	
	
	
	
	
	}
	
	void num() {
		int arr[]= {1,2,4,1,7,2,5,0,4,6,-1,-2};
		int num = 5;
		
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<arr.length;i++)
		{
			
			int currentSum=num-arr[i];
			
			for(int j=i+1;j<arr.length;j++)
			{
			
			
			Integer complement = map.get(currentSum-arr[j]);
			if(complement!=null)
			{
				System.out.println(arr[i] +" + "+arr[complement]+" + "+arr[j] +" = "+ num);
			}
			//Integer temp=currentSum-arr[j];
			map.put(arr[j], j);
			
			
			}
			
		}

	}
	
	
	
	
	

	static boolean reaaranged(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		boolean flag = true;
		boolean odd = false;

		for (int i = 0; i < s.length(); i++) {

			if (!map.containsKey(s.charAt(i))) {

				map.put(s.charAt(i), 1);

			}

			else {

				int temp = map.get(s.charAt(i));

				map.put(s.charAt(i), temp + 1);

			}

		}

		if ((s.length() % 2) == 0) {

			for (Entry<Character, Integer> entry : map.entrySet()) {

				if (entry.getValue() % 2 != 0)

				{

					flag = false;
					break;
				}

			}

		}

		else {

			for (Entry<Character, Integer> entry : map.entrySet()) {

				if (entry.getValue() % 2 != 0 && !odd) {
					odd = true;

				}

				else if (entry.getValue() % 2 == 0)

				{
					flag = true;
				} else {
					flag = false;
					break;
				}

			}

		}

		return flag;

	}

}
