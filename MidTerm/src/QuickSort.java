import java.util.Scanner;

/**
 * This class improves quick sort partition, The partition procedure:- forward
 * pass on the array to check elements smaller - backward pass on the array to
 * elements greater than pivot In theory if divide array to <pivot and >pivot
 * then the last part of the array is equal to pivot
 * 
 * @author zchem
 *
 */
public class QuickSort {
	/**
	 * This method separates array to elements greater than pivot, by doing a
	 * backward pass
	 * 
	 * @param arr
	 * @param low  boundary
	 * @param high boundary
	 * @return the index of the last element swapped
	 */
	public static int partitionGreater(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = high;
		for (int k = high; k >= low; k--) {
			if (arr[k] > pivot) {

				int temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
				i--;

			}
		}
		return i;
	}

	/**
	 * This method does a forward pass and separates elements smaller than the pivot
	 * 
	 * @param arr
	 * @param low  boundary
	 * @param high boundary
	 * @return the index of the last element swapped
	 */
	public static int partitionLess(int[] arr, int low, int high) {

		int pivot = arr[high];

		int i = low;

		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {

				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;

			}
		}
		return i;

	}

	/**
	 * This method invokes the {@link #partitionGreater(int[], int, int)} and
	 * {@linkplain #partitionLess(int[], int, int)}
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int i = partitionLess(arr, low, high);// i is the index of the last swapped elements of forward pass
			int k = partitionGreater(arr, low, high);// k is the index of the last swapped elements of backward pass

			quickSort(arr, i + 1, high);
			quickSort(arr, low, i - 1);
			quickSort(arr, k + 1, high);
			quickSort(arr, low, k - 1);
		}
	}

	public static void main(String[] args) {
		// prompting for an array
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Array size");
		int size = scanner.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			System.out.println("Enter element: " + (i + 1));
			arr[i] = scanner.nextInt();
		}
		// invoking quicksort
		quickSort(arr, 0, size - 1);
		// printing the sorted array
		System.out.println("Sorted array:");
		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}

}
