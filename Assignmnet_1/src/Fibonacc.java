
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class calculates the Fibonacci of n that the user choose
 * @author Ziad Chemali
 *
 */
public class Fibonacc {
	///creating variables 
ArrayList<Double> fibList;//n
ArrayList<Double> fn;//Fn
Double answer;
/**
 * This is constructor where the 
 */
public Fibonacc() {
	fibList=new ArrayList<Double>();
	fn=new ArrayList<Double>();
	
	fn.add((double) 0);
	fn.add((double) 1);
	fibList.add((double) 0);
	fibList.add((double) 1);
			
}
/**
 * This method use recursive call to find the Fibonacci of n
 * @param n users choice
 * @return Fn=F(n-1)+F(n-2)
 */
public double getF(int n) {
	
	
	for (int i=0 ;i<fibList.size();i++)
	{
		if (n == fibList.get(i)) {
			
			return fn.get(n);
		}}
	
		answer= (double) (getF(n-1)+getF(n-2));
		fibList.add((double) n);//adding n to array
		fn.add(answer);//adding Fn to array
		return answer;
	
	}

	public static void main(String[] args) {
		double time=System.currentTimeMillis();
		Fibonacc fib =new Fibonacc();
		boolean check=true;
		while (check) {
			Scanner scanner =new Scanner(System.in);
			System.out.println("Enter n between 0 and 45");
			int n=scanner.nextInt();
			if (n>=0 && n<=45) {
				System.out.println("Fibonacci of "+n+" is: "+fib.getF(n));
			}
			else {
				System.out.println("Choose n between 0 and 45");
			}
			System.out.println("Do you want to calculate another n Yes/No");
			String answr;
			answr=scanner.next();
			if (!answr.equalsIgnoreCase("Yes")) {
				check=false;
			}
			
		}
		
		
		
		

	}

}
