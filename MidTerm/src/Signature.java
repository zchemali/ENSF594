import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import javax.jws.Oneway;

public class Signature {
	// key: first num, length
	static HashMap<Integer,Integer> test =new HashMap<Integer, Integer>();
	
//public static ArrayList<ArrayList> findCommon(ArrayList<ArrayList> data) {
//	ArrayList<ArrayList> unique= new ArrayList<ArrayList>();
//		for (int i=0;i<data.size();i++) {
//			ArrayList<Integer> temp= new ArrayList<Integer>();
//				temp =data.get(i);
//			for(int k=0;k<data.size();k++) {
//				ArrayList<Integer> temp2= new ArrayList<Integer>();
//				temp2=data.get(k);
//			if (i!=k) {
////					System.err.println(temp+"     "+temp2);
//					unique.add(compare(temp,temp2) );
//					
//				
//				}
//			
//				
//			}
//			
//	}
//		
//	
//return unique;	
//	
//}

//	public static ArrayList compare(ArrayList<Integer> data1, ArrayList<Integer> data2) {
//
//		ArrayList<Integer> temp =new ArrayList<Integer>();
//		for( int i=0;i<data1.size();i++) {
//			for(int k=0;k<data2.size();k++) {
//				if(data1.get(i)==data2.get(k)) {
//					temp.add(data1.get(i));
//					if(test.containsKey(data1.get(i))) {
//						System.err.println(test.get(data1.get(i))+1);
//						test.put(data1.get(i), test.get(data1.get(i))+1);
//						
//					}
//					else
//					{
//						test.put(data1.get(i), 1);
//					}
//			}}
//		}
//		return temp;
//	}
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
		System.out.println(end);
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