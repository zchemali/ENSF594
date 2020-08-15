import java.util.Arrays;
import java.util.Random;

public class Exercise1 {
	/**
	 * Swapping two elemnts at a time, last elemnts every pass is the biggest
	 * my own implementaion  by understanding how the algorithm work
	 * @param array
	 */
	public void BubbleSort(int[] array) {
	int n=array.length;
	while(n>0) {
		for (int i=0;i<n-1;i++) {
			if(array[i]>array[i+1]) {
				int temp =array[i];
				array[i]=array[i+1];
				array[i+1]=temp;
			}
			
			
		}
		n--;
	}
		
	}
	/**
	 * two loops , first loop goesfrom 1st to length-1 of the array and choose the elments and put it in 
	 * the correct position by using a second loop
	 * second loop goes backward i-1 to 0 and puts the elment in correct posiotn
	 * @param array
	 */
	public void InsertionSort (int[] array) {
		
		for (int i=1 ;i<array.length;i++) {
			int temp=array[i];
			for (int j=i-1; j>=0;j--) {
				if(array[j]>temp) {
					array[j+1]=array[j];
					array[j]=temp;
				}
			}
		}
		
	}
	public void MergeSort(int[] array) {
		
	}
	public void QuickSort(int [] array) {
		
	}
	public void fillArray(int [] array,int type) {
		System.out.println("Filling Array");
		Random r =new Random();
		int flag=r.nextBoolean() ? 1:-1;
		array[0]=(int)(Math.random()*r.nextInt(1000)*flag//setting first element 
				);
		if (type==0)
			for (int i=1;i<array.length;i++) {
				array[i]=(int)(Math.random()*r.nextInt(100)+ array[i-1]);
			}
		else if(type==1)
			{System.out.println("GGG"+array[0]+"\n");
			for (int i=1;i<array.length;i++) {
				array[i]=(int)(array[i-1]-Math.random()*r.nextInt(100));
			}}
		else {
			System.out.println("TYPE 2"+type);
			for (int i=1;i<array.length;i++) {
				flag=r.nextBoolean() ? 1:-1;
				array[i]=(int)(Math.random()*r.nextInt(100)*flag);
			}
			
			
			
		
	}}
	

	public static void main(String[] args) {
		String outputfile;
		double time = 0;
		int size = 0,type =-1,algorithm=-1;
			
			if(args[0].equalsIgnoreCase("ascending"))
					type=0;
			else if(args[0].equalsIgnoreCase("descending") )
					type=1;
			else if(args[0].equalsIgnoreCase("random"))
					type=2;
		else {
			System.err.println("Use one of the following strings for Order: ascending, descending, random"+"\n Aborting...");
			System.exit(0);
		}
		
			
		try {
		 size=Integer.parseInt(args[1]);
		if(size<=0) {
			System.err.println("Size must be positive integer"+"\n Aborting...");
			System.exit(0);
		}
		} catch(Exception e) {
			System.err.println("Size must be an integer"+"\n Aborting...");
			System.exit(0);
		}
		
		
		if( args[2].equalsIgnoreCase("bubble") )
			 algorithm=0;
		else if (args[2].equalsIgnoreCase("insertion") )
		algorithm=1;
		else if (args[2].equalsIgnoreCase("merge") )
			algorithm=2;
		else if (args[2].equalsIgnoreCase("quick"))
			algorithm=3;
		else {
			System.err.println("Use one of the following strings for Algorithm: bubble, insertion, merge, quick"+"\nAborting...");
			System.exit(0);
		}
		
	
		 outputfile=args[3];
		 //create and fill array
		 int[] array=new int[size];
		Exercise1 ex=new Exercise1();
		ex.fillArray(array, type);
		//calling sort method
		System.out.println("Sorting ....");
		if(algorithm==0) {
			long start =System.nanoTime();
			ex.BubbleSort(array);
			time=(System.nanoTime()-start)/Math.pow(10, 9);
		}
		else if (algorithm==1) {
			long start =System.nanoTime();
			ex.InsertionSort(array);
			time=(System.nanoTime()-start)/Math.pow(10, 9);
		}
		else if (algorithm==2) {
			long start =System.nanoTime();
			ex.MergeSort(array);
			time=(System.nanoTime()-start)/Math.pow(10, 9);
		}
		else if (algorithm==3) {
			long start =System.nanoTime();
			ex.QuickSort(array);
			time=(System.nanoTime()-start)/Math.pow(10, 9);
		}
		
		//TODO write to file
		
		System.out.println(Arrays.toString(array));
		System.out.println("DONE");
		System.out.println("Total time in sec is "+ time);
	}

}
