import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * This class compares the time needed to sort arrays of different size by using
 * different sorting algorithms
 * 
 * @author zchem
 *
 */
public class Exercise1 {
	/**
	 * Swapping two elements at a time, last elements every pass is the biggest My
	 * own implementation by understanding how the algorithm work
	 * 
	 * @param array
	 */
	public void bubbleSort(int[] array) {
		int n = array.length;
		while (n > 0) {
			for (int i = 0; i < n - 1; i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}

			}
			n--;
		}

	}

	/**
	 * Two loops , first loop goes from 1st to length-1 of the array and choose the
	 * elrments and put it in the correct position by using a second loop second
	 * loop goes backward i-1 to 0 and puts the element in correct position
	 * 
	 * @param array
	 */
	public void insertionSort(int[] array) {

		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			for (int j = i - 1; j >= 0; j--) {
				if (array[j] > temp) {
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}

	}

	/**
	 * from https://www.geeksforgeeks.org/merge-sort/ The merge sort is divide and
	 * conquer, keep dividing until you end up with 2 or 1 elements then merge/sort
	 * 
	 * @param arrayint
	 * @param l        left index
	 * @param r        right index
	 */
	public void mergeSort(int[] array, int l, int r) {

		if (r > l) {
			int m = (l + r) / 2;
			mergeSort(array, l, m);// left section of the array
			mergeSort(array, m + 1, r);// right section
			// invoke Merge when elements of both left/right section are 1 or 2
			merge(array, l, m, r);
		}

	}

	/**
	 * This method simply compares the two sub arrays (l/r) and merge them together
	 * 
	 * @param array
	 * @param l     left index
	 * @param m     mid
	 * @param r     right index
	 */
	public void merge(int[] array, int l, int m, int r) {
		int[] leftArray = new int[m - l + 1];
		int[] rightArray = new int[r - m];
		// Filling left arary
		for (int i = 0; i < leftArray.length; i++) {
			leftArray[i] = array[l + i];
		}
		// filling right array
		for (int i = 0; i < rightArray.length; i++) {
			rightArray[i] = array[m + 1 + i];// +1 since the right array starts at m+1
		}

		// compare and merge
		int i = 0, j = 0;
		int k = l;// actual array
		while (i < leftArray.length && j < rightArray.length) {
			if (leftArray[i] <= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}

		// copy remainder of left array if any Note: in case you have one element only
		while (i < leftArray.length) {
			array[k] = leftArray[i];
			i++;
			k++;
		}
		// copy remainder of left array if any Note: in case you have one element only
		while (j < rightArray.length) {
			array[k] = rightArray[j];
			j++;
			k++;
		}

	}

	/**
	 * from https://www.geeksforgeeks.org/quick-sort/ this is divide and conquer
	 * algorithm picks last element as pivot then partition the array around the
	 * pivot
	 * 
	 * @param array
	 * @param low
	 * @param high
	 */
	public void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int index = partition(array, low, high);
			if (index > 0 && (index) < high) {
				quickSort(array, low, index - 1);
				quickSort(array, index + 1, high);
			}
		}

	}

	/**
	 * This function is used by quickSort to put values <= pivot to left and values
	 * > pivot to right
	 * 
	 * @param array
	 * @param low
	 * @param high
	 * @return the index at which the last swap occured
	 */
	public int partition(int[] array, int low, int high) {
		double pivot = array[high];
		int i = low;// i is the last element that swapping has occurred
		for (int j = low; j < high; j++) {
			if (array[j] <= pivot) {

				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				i++;

			}
		}
		// swapping the pivot with the element at i
		int temp = array[i];
		array[i] = (int) pivot;
		array[high] = temp;
		return i;

	}

	/**
	 * This function writes the time needed to sort the array as well as the sorted
	 * array to a txt file
	 * 
	 * @param array
	 * @param order
	 * @param algorithm
	 * @param size
	 * @param time
	 * @param outputfile
	 */
	public void writeFile(int[] array, String order, String algorithm, int size, double time, String outputfile) {
		StringBuffer sb = new StringBuffer();
		sb.append("Array of size " + size + " is filled at " + order + " order \n");
		sb.append("Time needed using " + algorithm + " sort is: " + time + " s\n");
		sb.append("The sorted Array:\n");
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i] + "\n");
		}
		File file = new File(outputfile);
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(sb.toString());
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This function is used to fill an array either ascending,random, or descending
	 * order (
	 * 
	 * @param array
	 * @param type
	 */
	public void fillArray(int[] array, String type) {
		System.out.println("Filling Array");
		Random r = new Random();
		int flag = r.nextBoolean() ? 1 : -1;
		array[0] = (int) (Math.random() * r.nextInt(1000) * flag// setting first element
		);
		if (type.equals("ascending"))
			for (int i = 1; i < array.length; i++) {
				array[i] = (int) (Math.random() * r.nextInt(100) + array[i - 1]);
			}
		else if (type.equals("descending")) {
			for (int i = 1; i < array.length; i++) {
				array[i] = (int) (array[i - 1] - Math.random() * r.nextInt(100));
			}
		} else {
			for (int i = 1; i < array.length; i++) {
				flag = r.nextBoolean() ? 1 : -1;
				array[i] = (int) (Math.random() * r.nextInt(1000) * flag);
			}

		}
	}

	public static void main(String[] args) {
		String outputfile = null, algorithm = null, order = null;
		double time = 0;
		int size = 0;
		// checking passed args at run time
		if (args[0].equalsIgnoreCase("ascending"))
			order = "ascending";
		else if (args[0].equalsIgnoreCase("descending"))
			order = "descending";
		else if (args[0].equalsIgnoreCase("random"))
			order = "random";
		else {
			System.err.println(
					"Use one of the following strings for Order: ascending, descending, random" + "\n Aborting...");
			System.exit(0);
		}

		try {
			size = Integer.parseInt(args[1]);
			if (size <= 0) {
				System.err.println("Size must be positive integer" + "\n Aborting...");
				System.exit(0);
			}
		} catch (Exception e) {
			System.err.println("Size must be an integer" + "\n Aborting...");
			System.exit(0);
		}

		if (args[2].equalsIgnoreCase("bubble"))
			algorithm = "bubble";
		else if (args[2].equalsIgnoreCase("insertion"))
			algorithm = "insertion";
		else if (args[2].equalsIgnoreCase("merge"))
			algorithm = "merge";
		else if (args[2].equalsIgnoreCase("quick"))
			algorithm = "quick";
		else {
			System.err.println("Use one of the following strings for Algorithm: bubble, insertion, merge, quick"
					+ "\nAborting...");
			System.exit(0);
		}

		if (args[3].contains(".txt")) {
			outputfile = args[3];
		} else {
			System.err.println("Outputfile must have .txt at the end\nAborting...");
			System.exit(0);
		}
		// create and fill array
		int[] array = new int[size];
		Exercise1 ex = new Exercise1();
		ex.fillArray(array, order);
		// calling sort method
		System.out.println("Sorting ....");
		if (algorithm.equals("bubble")) {
			long start = System.nanoTime();
			ex.bubbleSort(array);
			time = (System.nanoTime() - start) / Math.pow(10, 9);
		} else if (algorithm.equals("insertion")) {
			long start = System.nanoTime();
			ex.insertionSort(array);
			time = (System.nanoTime() - start) / Math.pow(10, 9);
		} else if (algorithm.equals("merge")) {
			long start = System.nanoTime();
			ex.mergeSort(array, 0, size - 1);
			time = (System.nanoTime() - start) / Math.pow(10, 9);
		} else if (algorithm.equals("quick")) {
			long start = System.nanoTime();
			ex.quickSort(array, 0, size - 1);
			time = (System.nanoTime() - start) / Math.pow(10, 9);
		}
		System.out.println("Sorting Done \nWriting to file");
		// writing result to file
		ex.writeFile(array, order, algorithm, size, time, outputfile);
		System.out.println("Success!");
	}

}
