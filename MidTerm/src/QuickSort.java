import java.util.Arrays;

public class QuickSort {
	public static  int partitionGreater(int[] arr, int low , int high) {
		int pivot =arr[high];
		int i=high;
		for (int k=high;k>=low;k--) {
			if(arr[k]>pivot) {
				
				int temp=arr[i];
				arr[i]=arr[k];
				arr[k]=temp;
//				System.err.println("First loop "+arr[k]);
				i--;
//				System.err.println("k "+k);
				
			}}
		return i;}
public static  int partitionLess(int[] arr, int low , int high) {
	

	int pivot = arr[high];
	
	int i=low;
	
	for (int j=low;j<high;j++) {
		if(arr[j]<pivot) {
			
			int temp=arr[j];
			arr[j]=arr[i];
			arr[i]=temp;
			i++;
		
		
			}}
//	System.err.println(i);
	System.err.println(i+"  "+low+"   "+high);
	return i;
//	System.err.println("in loop"+ low+"  "+high);
	
}

public static void quickSort(int[] arr,int low, int high) {
	if(low<high) {
		int i=partitionLess(arr, low, high);
		int k=partitionGreater(arr, low, high);
		
		quickSort(arr, i+1, high);
		quickSort(arr, low, i-1);
		quickSort(arr, k+1, high);
		quickSort(arr, low, k-1);
	}
}
	public static void main(String[] args) {
		long time =System.nanoTime();
		int [] test = {2,3,9,2,2,1,5,6,3,2,6,3,1,2,4,6,-2,2,3,-5,2,23,5,1,232,3,2,-34324,-2,9,23,1,1,2,3,4};
	
//		quickSort(test, 0, test.length-1);
		Arrays.sort(test);
		for (int i=0;i<test.length;i++)
		System.out.println(test[i]);
	System.out.println("Time "+(System.nanoTime()-time)*Math.pow(10, -9));
	}


}
