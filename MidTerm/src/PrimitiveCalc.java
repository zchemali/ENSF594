import java.util.ArrayList;
import java.util.HashMap;

public class PrimitiveCalc {
	/**
	 * USe GReedy algorithm divide 3 then 2 then sub by 1 
	 * 
	 * mul x2 
	 * mul x3
	 * add 1
	 * @param args
	 * Bottom up aproach 
	 * creat a list same size as n and fill it with min number of operation to get counter 
	 * use % to check if index is divisible by 2/3 
	 * if it is then get storage [i/2]+1 --> counter
	 */
	Integer countSum=0,count2=0,count3=0;
	static HashMap<Integer,String>combo=new HashMap<Integer, String>();

public int dynamicProgramming(int [] n) {
	
	
for (int i=2 ;i<n.length;i++) {
	int countSum=100,count_x2=100,count_x3=100;
	countSum=1+n[i-1];
	if(i%2==0 && i/2>=0) {
		count_x2=1+n[i/2];
	}
	if(i%3==0 && i/3>=0) {
		count_x3=1+n[i/3];
	}
	String test = null;
	if(countSum< count_x2 & countSum< count_x3)	{
		test="sum";
	}
	else if(count_x2< countSum & count_x2< count_x3)	{
		test="x2";
	}
	else if(count_x3< countSum & count_x3< count_x2)	{
		test="x3";
	}
	int temp=Math.min(countSum, count_x2);
	n[i]=Math.min(temp, count_x3);
	combo.put(i,test);
	System.out.println(n[i]+" "+test);
	
}
return n[n.length-1];

	
}
	public static void main(String[] args) {
		PrimitiveCalc pc =new PrimitiveCalc();
		//ALways go 1+ number since we are using indexes
		int[] l=new int[96235];
		int n=pc.dynamicProgramming(l);
		System.out.print(n);
		

	}

}
