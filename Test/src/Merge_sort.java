import java.util.Arrays;

public class Merge_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr1[] = { 2, 10, 6, 12, 8, 40, 30 };
		int arr2[] = { 32, 1, 41, 33 };

		
		  int[] arr= mergeArray(arr1,0,arr1.length-1);
		  
		  for(int i=0;i<arr.length;i++) 
		  { System.out.println(arr[i]);
		  
		  }
		 

		int arr3[] = merge2Array(arr1, arr2);

		for (int m = 0; m < arr3.length; m++) {
			System.out.println(arr3[m]);
		}
	}

	static int[] mergeArray(int arr[], int low, int high) {

		if (low == high) {
			int a[] = new int[1];
			a[0] = arr[low];
			return a;
		}

		int mid = (low + high) / 2;

		int arr1[] = mergeArray(arr, low, mid);
		int arr2[] = mergeArray(arr, mid + 1, high);

		int arrR[] = merge2Array(arr1, arr2);
		return arrR;
	}

	static int[] merge2Array(int arr1[], int arr2[]) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int a = arr1.length - 1;
		int b = arr2.length - 1;
		int arr3[] = new int[arr1.length + arr2.length];
		int i = 0, j = 0, c = 0;

		while (a >= i && b >= j) {

			if (arr1[i] < arr2[j]) {
				arr3[c] = arr1[i];
				c++;
				i++;
			}

			else {
				arr3[c] = arr2[j];
				c++;
				j++;

			}

		}

		while (a >= i) {

			arr3[c] = arr1[i];
			c++;
			i++;

		}

		while (b >= j) {

			arr3[c] = arr2[j];
			c++;
			j++;

		}
		return arr3;

	}

}
