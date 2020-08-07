
/**
 * This class uses bottom-up dynamic programming 
 * to find minimum number of operations  to obtain
 * an integer n starting from1
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class PrimitiveCalc {
	// global ArrayList used to store the min number of operation at index, and the
	// type of operation sum,x2,x3
	static HashMap<Integer, String> comb = new HashMap<Integer, String>();

	/**
	 * 
	 * @param n the storage array that contains min operation per index
	 * @return the last index of n
	 */
	public int dynamicProgramming(int[] n) {
		comb.put(1, "Sum");

		for (int i = 2; i < n.length; i++) {
			// temp variables
			int countSum = 100, count_x2 = 100, count_x3 = 100;
			countSum = 1 + n[i - 1];// Incrementing the storage value at i-1 by 1
			if (i % 2 == 0 && i / 2 >= 0) {
				count_x2 = 1 + n[i / 2];// Incrementing the storage value at i/2 by 1
			}
			if (i % 3 == 0 && i / 3 >= 0) {
				count_x3 = 1 + n[i / 3];// Incrementing the storage value at i/3 by 1
			}
			// Filling HashMap key is the index, value is the type of operation
			if (countSum <= count_x2 && countSum <= count_x3) {
				comb.put(i, "Sum");// if at index i the min is found using sum so store key=i, value=Sum
			} else if (count_x2 <= count_x3 && count_x2 <= countSum) {
				comb.put(i, "x2");// if at index i the min is found using multiplication of 2 so store key=i,
									// value=x2
			} else if (count_x3 <= count_x2 && count_x3 <= countSum) {
				comb.put(i, "x3");// if at index i the min is found using multiplication of 3 so store key=i,
									// value=x3
			}
			// Finding min between counts before storing it in the storage array
			int temp = Math.min(countSum, count_x2);
			n[i] = Math.min(temp, count_x3);

		}
		return n[n.length - 1];

	}

	/**
	 * This method goes through comb HashMap and fills the arrayList with sequence
	 * of intermediate numbers Then sort it and print it
	 * 
	 * @param output ArrayList contains the numbers that are equal to prev number
	 *               X2, x3 ,or x+1
	 * @param num    final number
	 */
	public void printOutput(ArrayList<Integer> output, int num) {
		while (num >= 1) {
			if (comb.get(num) == "Sum") {
				num -= 1;
				if (num > 0)
					output.add(num);

			} else if (comb.get(num) == "x2") {

				num = num / 2;
				if (num > 0)
					output.add(num);
			} else if (comb.get(num) == "x3") {

				num = num / 3;
				if (num > 0)
					output.add(num);
			} else
				break;
		}
		Collections.sort(output);
		System.out.println("\n" + output);

	}

	public static void main(String[] args) {
		// creating objects
		ArrayList<Integer> output = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		PrimitiveCalc pc = new PrimitiveCalc();
		// prompting the user
		System.out.println("Enter intger between 1 and 10^6");
		int i = scanner.nextInt();
		// creating storage array to hold the min number of operation from 1 to i+1
		int[] storage = new int[i + 1];
		int n = pc.dynamicProgramming(storage);
		System.out.print("The minimum number of operations is: " + n);
		output.add(i);
		// printing intermediate sequence
		pc.printOutput(output, i);

	}

}
