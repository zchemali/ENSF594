import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class reads a txt file of words and checks all the anagrams contained in
 * this text file, then write the result to an output file
 * 
 * @author zchem
 *
 */
public class Excercise2 {
	/**
	 * This function sorts list of characters in ascending order
	 * 
	 * @param array
	 */
	public void insertionSort(char[] array) {

		for (int i = 1; i < array.length; i++) {
			char temp = array[i];
			for (int j = i - 1; j >= 0; j--) {
				if (array[j] > temp) {
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}

	}

	/**
	 * This function reads inputfile and read every line and checks if an angarm
	 * exists
	 * 
	 * @param da        DynamicArray object
	 * @param inputfile
	 */
	public void readFile(DynamicArray da, String inputfile) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputfile));
			String word;
			System.out.println("Reading File/creating list of anagrams...");
			while ((word = reader.readLine()) != null) {
				/// converting the word to a key
				char[] temp = new char[word.length()];
				for (int i = 0; i < temp.length; i++) {
					temp[i] = word.charAt(i);
				}
				insertionSort(temp);
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < temp.length; i++) {
					sb.append(temp[i]);
				}
				String key = sb.toString();

				// checking if key exists in dynamic array
				int i = da.linearSearch(key);
				// if key exist then append the word to the linked list
				if (i >= 0) {
					da.arrayLinked[i].insertAtEnd(new Node(word));

				}
				// if key doesnt exist then add it to the dynamicArray and create a new linked
				// list
				else {
					LinkedList ll1 = new LinkedList(key);
					ll1.insertAtEnd(new Node(word));
					da.add(ll1);
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	public static void main(String[] args) {

		String inputfile = null, outputfile = null;
		// checking args
		if (args[0].contains(".txt") && !args[0].equals(args[1]) && args[1].contains(".txt")) {
			inputfile = args[0];
			outputfile = args[1];

		} else {
			System.err.println("Inputfile and outputfile must contain .txt and they must not be equal");
			System.exit(0);
		}
		DynamicArray da = new DynamicArray();
		Excercise2 ex = new Excercise2();
		// processing data
		long start = System.nanoTime();
		ex.readFile(da, inputfile);
		double time = (System.nanoTime() - start) / Math.pow(10, 9);
		System.out.println("Sorting....");
		// sorting the dynamic array
		da.quickSort(0, da.getSize() - 1);
		// sorting the linkedlists in the array
		da.sort();
		// writing result to outputfile
		String result = "Time needed to read/process file is: " + time + " s\n" + da.print();
		System.out.println("Wrting to file");
		File file = new File(outputfile);
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(result);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Success!");
	}

}
