import java.util.Scanner;

public class BinarySearch {

	public int binarySearch(int[] list,int key) {
		
		int mid,low,high;
		low=0;
		high=list.length;
		
		while(low<high) {
		mid=(low+high)/2;
		
		if( key== list[mid])
			return mid;
		else if (key>list[mid]) {
			low=mid+1;
		
		}
		else if (key<list[mid]) {
			high=mid-1;
		}
		
		
		
	}
		return -1;
	}
	public static void main(String[] args) {
		BinarySearch bs= new BinarySearch();
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter size of the sorted list");
		int n=scanner.nextInt();
		int[] sortedList=new int[n];
		for (int i=0 ;i<n ;i++) {
			System.out.println("Enter element "+(i+1)+" of this sorted list");
			sortedList[i]=scanner.nextInt();
		}
		
		System.out.println(" How many numbers you are searching for ?");
		int k=scanner.nextInt();
		int[] listNumbers=new int[k];
		int[] index=new int[k];
		for (int i=0;i<k;i++) {
			System.out.println(" Enter a number to search in the sorted list");
			listNumbers[i]=scanner.nextInt();
			index[i]=bs.binarySearch(sortedList, listNumbers[i]);
			
		}
		for (int i=0;i<k;i++) {
			System.out.println("The index of "+listNumbers[i]+" is "+index[i]);
		}

	}

}
