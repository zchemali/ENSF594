import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * You sort end points ,
 * then compare the beg points to threshold 
 * if beg>threshold then appemd end point and threshold =endpoint
 * repreat until you have reached all segments
 * @author zchem
 *
 */
public class Signature {


	public static void main(String[] args) {
		ArrayList<Integer> end=new ArrayList<Integer>();
		ArrayList<Integer> beg=new ArrayList<Integer>();
		ArrayList<Integer> points=new ArrayList<Integer>();
		HashMap<Integer,Integer> segments=new HashMap<Integer, Integer>();
		HashMap<Integer,Integer> segmentsRevers=new HashMap<Integer, Integer>();
		Scanner scanner =new Scanner(System.in);
		System.out.println(" How many segments");
		int n=scanner.nextInt();
		for(int i=0 ;i<n;i++) {
			System.out.println("Enter first pair of elment"+ (i+1));
			int a= scanner .nextInt();
			System.out.println("Enter second pair of elment"+ (i+1));
			int b= scanner .nextInt();
			ArrayList<Integer> temp =new ArrayList<Integer>();
			segments.put(a,b);
			segmentsRevers.put(b,a);
		}
		beg.addAll(segments.keySet());
		end.addAll(segments.values());
		Collections.sort(beg);
		Collections.sort(end);
//		System.out.println(end);
		int compare=beg.get(0)-1;
		
		for (int i=0;i<end.size();i++) {
//			if(segmentsRevers.get(end.))
//			System.out.println(segmentsRevers.get(end.get(i))+"    "+end.get(i));
		if(segmentsRevers.get(end.get(i))>compare) {
			points.add(end.get(i));
			compare=end.get(i);
		}
		
		}
		System.out.println(points);
		
		
	
		
		
//		count=Signature.findCommon(lis);
		
//		for (int i=0 ;i<count.size();i++) {
//			if(count.get(i).size()==0)
//			count.remove(i);
//		}
//		count=Signature.findCommon(count);
//		for (int i=0 ;i<count.size();i++) {
//			if(count.get(i).size()!=0) {

//		
	
		
		
	}
	}