import java.util.Scanner;

/**
 * This class solves the Money Change problem using bottom-up dynamic
 * programming
 * 
 * @author zchem
 *
 */
public class MoneyChange {
	/**
	 * This method uses bottom-up approach
	 * 
	 * @param storage its an array to store min value of coins at each index
	 * @param a       1 coins
	 * @param b       3 coins
	 * @param c       4 coins
	 * @return
	 */
	public static int findMin(int[] storage, int a, int b, int c) {
		for (int i = 0; i < storage.length; i++) {
			int temp = storage[i];
			int sub_a = i - a;// i-1
			int sub_b = i - b;// i-3
			int sub_c = i - c;// i-4

			int counta = temp, countb = temp, countc = temp;

			if (sub_a >= 0) {
				counta = 1 + storage[i - a];// 1 + storage value at i-1
			}
			if (sub_b >= 0) {
				countb = 1 + storage[i - b];// 1 + storage value at i-3
			}
			if (sub_c >= 0) {
				countc = 1 + storage[i - c];// 1 + storage value at i-4
			}
			// find min between counta,countb, and countc
			// then change value of storage at i
			int temp_count = Math.min(counta, countb);
			storage[i] = Math.min(temp_count, countc);

		}
//return the last index of the storage array
		return storage[storage.length - 1];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an intger between 1 and 10^3 ");
		int num = scanner.nextInt();
		int a = 1, b = 3, c = 4;
		// creating storage array
		int[] storage = new int[num + 1];
		// filling array with numbers
		storage[0] = 0;

		for (int i = 1; i < storage.length; i++) {

			storage[i] = num;
		}
		// invoking find() method
		int test = MoneyChange.findMin(storage, a, b, c);
		System.out.println("Minimum number of coins is : " + test);
	}

}
