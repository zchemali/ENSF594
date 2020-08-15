import java.util.Arrays;
import java.util.Random;

public class Exercise1 {
	public void BubbleSort(int[] array) {
		
	}
	public void InsertionSort (int[] array) {
		
	}
	public void MergeSort(int[] array) {
		
	}
	public void QuickSort(int [] array) {
		
	}
	public void fillArray(int [] array,int type) {
		Random r =new Random();
		int flag=r.nextBoolean() ? 1:-1;
		array[0]=(int)(Math.random()*r.nextInt(100)*flag
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
		String order = null,algorithm = null,outputfile;
		int size = 0,type =-1;
			
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
		if( args[2].equalsIgnoreCase("bubble") || args[2].equalsIgnoreCase("insertion") || args[2].equalsIgnoreCase("merge") || args[2].equalsIgnoreCase("quick")) {
			 algorithm=args[2];
		}
		else {
			System.err.println("Use one of the following strings for Algorithm: bubble, insertion, merge, quick"+"\nAborting...");
			System.exit(0);
		}
		
	
		 outputfile=args[3];
		 int[] array=new int[size];
		
		Exercise1 ex=new Exercise1();
		ex.fillArray(array, type);
		System.out.println(Arrays.toString(array));

	}

}
