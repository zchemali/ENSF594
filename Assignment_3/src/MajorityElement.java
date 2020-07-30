import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MajorityElement {

	public int checkMajority(int[] list) {
		HashMap <Integer,Integer> map =new HashMap<Integer, Integer>();
		for (int i=0 ;i<list.length;i++) {
			if(!map.containsKey(list[i])) {
				map.put(list[i], 1);
			
			}
			else
				map.put(list[i],map.get(list[i])+1);
			
		}
		ArrayList<Integer> values =new ArrayList<Integer>();
		values.addAll(map.values());
		for (int i = 0;i<values.size();i++) {
			if(values.get(i)>(list.length/2))
				return 1;
		}
		return 0;
	}
	public static void main(String[] args) {
		MajorityElement me =new   MajorityElement();
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter size of the list");
		int n=scanner.nextInt();
		int[] list=new int[n];
		for (int i=0 ;i<n ;i++) {
			System.out.println("Enter element "+(i+1)+" of this list");
			list[i]=scanner.nextInt();
		}
		
		System.out.println("Majority element check "+me.checkMajority(list));
	}

}
