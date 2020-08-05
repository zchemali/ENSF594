import java.util.ArrayList;
import java.util.HashMap;

public class MoneyChange {
public static int findMin (int[] storage, int a ,int b, int c) {
for (int i=0;i<storage.length;i++) {
	int temp =storage[i];
	int sub_a=i-a;//i-1
	int sub_b=i-b;//1-3
	int sub_c=i-c;//i-4

	int counta=temp,countb=temp,countc=temp;
	if(sub_a>=0 && (i-a)>=0) {
//		System.out.println("-a at index " +i+" "+sub_a);
		 counta=1+storage[i-a];
	}
	if(sub_b>=0 && (i-b)>=0) {
//		System.out.println("-b index  "+i+" "+sub_b);
		countb=1+storage[i-b];
	}
	if(sub_c>=0 && (i-c)>=0) {
//		System.out.println("-b "+sub_c);
		countc=1+storage[i-c];
	}
	
	int temp_count=Math.min(counta, countb);
	storage[i]=Math.min(temp_count, countc);
//	System.out.println("a "+counta+"b "+countb+" c "+countc);
//	System.out.println("Min at index " + i+" is "+storage[i]);
	
}
return storage[storage.length-1];
}
	public static void main(String[] args) {
		int num=34;
		int a=1,b=3,c=4;
		int[] storage=new  int[num+1];
		storage[0]=0;
		

		for (int i=1 ;i<storage.length;i++) {
			
			storage[i]=num;
		}
		int test=MoneyChange.findMin(storage, a, b, c);
		System.out.println(test);
	}
	

}
