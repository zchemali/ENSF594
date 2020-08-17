/**
 * This class creates a Dynamic Array of each elements is a linkedList. This
 * array size keeps increasing as new linkedlists are added
 * 
 * @author zchem
 *
 */
public class DynamicArray {
	// creating variables
	LinkedList[] arrayLinked = new LinkedList[1];
	int size = 1;

	/**
	 * Adds another elements to the dynamic array and increase the array size
	 * 
	 * @param ll LinkedList object
	 */
	public void add(LinkedList ll) {
		if (arrayLinked[size - 1] == null)
			arrayLinked[size - 1] = ll;
		else {
			size++;
			LinkedList[] temp = new LinkedList[size];
			for (int i = 0; i < arrayLinked.length; i++) {
				temp[i] = arrayLinked[i];

			}
			arrayLinked = temp;
			arrayLinked[size - 1] = ll;
		}
	}

	/**
	 * This function will append the key in addition to all the elements of the
	 * linked list by invoking print function in @LinkedList
	 * 
	 * @return a String of key + list of Anagrams for each key
	 */
	public String print() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arrayLinked.length; i++) {
			sb.append("Key: " + arrayLinked[i].getKey() + " Anagrams: " + arrayLinked[i].print() + "\n");

		}
		return sb.toString();
	}

	/**
	 * Sorts the dynamic array using quickSort method
	 * 
	 * @param low
	 * @param high
	 */
	public void quickSort(int low, int high) {
		if (low < high) {
			int index = partition(low, high);
			if (index > 0 && index <= high)// to avoid stack overflow
			{
				quickSort(low, index - 1);
				quickSort(index + 1, high);
			}
		}

	}

	/**
	 * This function is used by the quickSort function to separate elements less
	 * than pivot and elements greater than pivot
	 * 
	 * @param low
	 * @param high
	 * @return
	 */
	public int partition(int low, int high) {
		LinkedList pivot = arrayLinked[high];
		int i = low;// i is the last element that swapping has occurred
		for (int j = low; j < high; j++) {
			if (arrayLinked[j].getKey().compareTo(pivot.getKey()) < 0) {

				LinkedList temp = arrayLinked[j];
				arrayLinked[j] = arrayLinked[i];
				arrayLinked[i] = temp;
				i++;

			}
		}
		// swapping the pivot with the element at i
		LinkedList temp = arrayLinked[i];
		arrayLinked[i] = pivot;
		arrayLinked[high] = temp;
		return i;

	}

	// return size of dynamic array
	public int getSize() {
		return arrayLinked.length;
	}

	// Linear search if key exists in the dynamic array and return the index of it
	public int linearSearch(String key) {
		if (arrayLinked[0] != null) {
			for (int i = 0; i < arrayLinked.length; i++) {
				if (arrayLinked[i].getKey().equals(key)) {
					return i;

				}
			}
		}
		return -1;
	}

	/**
	 * Sort all of the linked lists stored in the dynamic array by invoking
	 * insetionSort function in @LinkedList class
	 */
	public void sort() {
		for (int i = 0; i < arrayLinked.length; i++) {
			arrayLinked[i].insertionSort();
		}
	}

}
