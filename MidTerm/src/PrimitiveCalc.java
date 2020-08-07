
/**
 * This class uses bottom-up dynamic programming 
 * to find minimum number of operations  to obtain
 * an integer n starting from1
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class PrimitiveCalc {
	static HashMap <Integer,String> comb=new HashMap<Integer, String>();
/**
 * 	
 * @param n the storage array that contains min operation per index
 * @return the last index of n
 */
public int dynamicProgramming(int [] n) {
	comb.put(1,"Sum");
	
for (int i=2 ;i<n.length;i++) {
	int countSum=100,count_x2=100,count_x3=100;
	countSum=1+n[i-1];
	if(i%2==0 && i/2>=0) {
		count_x2=1+n[i/2];
	}
	if(i%3==0 && i/3>=0) {
		count_x3=1+n[i/3];
	}
	if(countSum<=count_x2 && countSum<=count_x3) {
		comb.put(i,"Sum");
	}
	else if(count_x2<=count_x3 && count_x2<=countSum) {
		comb.put(i,"x2");
	}
	else if(count_x3<=count_x2 && count_x3<=countSum) {
		comb.put(i,"x3");
	}
	int temp=Math.min(countSum, count_x2);
	n[i]=Math.min(temp, count_x3);
	
}
return n[n.length-1];

	
}
public static void printOutput(ArrayList<Integer> output,int num) {
	while(num>=1) {
		if(comb.get(num)=="Sum")
			{
			num-=1;
			if(num>0)
			output.add(num);
			
			}
		else if (comb.get(num)=="x2") {
			
			num=num/2;
			if(num>0)
			output.add(num);
		}
		else if(comb.get(num)=="x3") {
			
			num=num/3;
			if(num>0)
			output.add(num);
		}
		else
			break;
	}
	Collections.sort(output);
	System.out.println("\n"+output);
	
}
	public static void main(String[] args) {
		ArrayList<Integer> output =new ArrayList<Integer>();
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter intger between 1 and 10^6");
		PrimitiveCalc pc =new PrimitiveCalc();
		int i=scanner.nextInt();
		int[] l=new int[i+1];
		int n=pc.dynamicProgramming(l);
		System.out.print("The minimum number of operations is: "+n);
		output.add(i);
		
		printOutput(output, i);
	

	}

} 
