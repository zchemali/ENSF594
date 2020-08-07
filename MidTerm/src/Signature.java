import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class finds min number of common points between segments
 * 
 * @author zchem
 *
 */
public class Signature {
	/**
	 * This method sorts the segments based on the end point then compares the start
	 * point of
	 * 
	 * @param segments
	 * @param segmentsRevers
	 */
	public static void findPoint(HashMap<Integer, Integer> segments, HashMap<Integer, Integer> segmentsRevers) {
		ArrayList<Integer> end = new ArrayList<Integer>();// array of endpoints
		ArrayList<Integer> beg = new ArrayList<Integer>();// array of start points
		ArrayList<Integer> points = new ArrayList<Integer>();// to store common points

		// filling the arrays
		beg.addAll(segments.keySet());
		end.addAll(segments.values());
		// sorting the arrays
		Collections.sort(beg);
		Collections.sort(end);
		// this variable is set to the minimum of startpoints array -1
		int pivot = beg.get(0) - 1;
		// iterate through endpoint array and compare the startpoint to pivot
		// if startpoint>pivot then append the endpoint of that segment into points
		// array
		for (int i = 0; i < end.size(); i++) {
			if (segmentsRevers.get(end.get(i)) > pivot) {
				points.add(end.get(i));
				pivot = end.get(i);
			}

		}
		// print common points between segments
		System.out.println("The common points between segments are: \n"+points);

	}

	public static void main(String[] args) {
		// initializing two hashmaps
		HashMap<Integer, Integer> segments = new HashMap<Integer, Integer>();// key=startpoint value=endpoint
		HashMap<Integer, Integer> segmentsRevers = new HashMap<Integer, Integer>();// key=endpoint value=startpoint
		// promoting user for the number of segments
		Scanner scanner = new Scanner(System.in);
		System.out.println(" How many segments");
		int n = scanner.nextInt();
		// getting the start / endpoint of each segment and
		// storing them in the HashMaps
		for (int i = 0; i < n; i++) {
			System.out.println("Enter first pair of elment" + (i + 1));
			int a = scanner.nextInt();
			System.out.println("Enter second pair of elment" + (i + 1));
			int b = scanner.nextInt();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			segments.put(a, b);
			segmentsRevers.put(b, a);
		}

		// invoking the findPoint method
		findPoint(segments, segmentsRevers);

	}
}