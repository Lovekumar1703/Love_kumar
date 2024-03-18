
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int array[] = { 0, 1, 2, 1, 1, 2, 0, 1, 2, 2 };

		int zero = 0;
		int one = 0;
		int two = 0;
		

		for (int i = 0; i < array.length; i++) {

			if (array[i] == 0) {

				zero++;

			} else if (array[i] == 1) {

				one++;

			} else {
				two++;
			}

		}

		for (int i = 0; i < array.length; i++) {

			if (i < zero) {

				array[i] = 0;

				System.out.println(array[i]);

			} else if (i >= zero && i < zero + one) {

				array[i] = 1;
				System.out.println(array[i]);

			} else {

				array[i] = 2;
				System.out.println(array[i]);

			}

		}

	}

}
