
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//fseries(9);
		lastValue(123);

	}

	
	
	public static void lastValue(int n) {
	
		int temp=0;
		int remainder=0;
		
		
	
	while(n>0)
	{
		
		
		temp= n%10;
		remainder=remainder*10+temp;
		n=n/10;
		System.out.println(n);
		
		
		
	}
	
	
	
	
	
	}
	
	
	
	public static int[] fseries(int n) {

		int arr[] = new int[n];
		arr[0] = 0;
		arr[1] = 1;

		System.out.println(arr[0]);
		System.out.println(arr[1]);

		for (int i = 2; i < n; i++) {

			arr[i] = arr[i - 1] + arr[i - 2];

			System.out.println(arr[i]);

		}

		return arr;
	}

}
