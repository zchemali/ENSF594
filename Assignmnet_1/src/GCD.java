import java.util.Scanner;
/**
 * This class calculates the GCD of two numbers using efficient algorithm
 * @author ziad chemali
 *
 */
public class GCD {
	/**
	 * This method divide a/b if remainder is zero then return b 
	 * else 
	 * recursive the method with b/remainder
	 * @param a numerator
	 * @param b denominator
	 * @return  denominator if remainder of a/b is zero
	 */
	public static int getGCD(int a,int b)
	{
		if(a%b==0) 
			return b;
		
		return getGCD(b,a%b);
		
	}

	public static void main(String[] args) {
		int a,b;
		Scanner scanner =new Scanner(System.in);
		boolean check=true;
		while (check) {
			System.out.println("Enter two Integers a,b between 1 and 2*10^9");
			a=scanner.nextInt();
			b=scanner.nextInt();
			if(a>=1 && a<=2*Math.pow(10, 9) || (b>=1 && b<=2*Math.pow(10, 9))) {
				System.out.println("GCD for a and b is : "+GCD.getGCD(a,b));	
			}
			else {
				System.out.println("Please enter a valid a,b numbers berween 1 and 2 *10^9");
			}
			System.out.println("Do you want to continue?");
			String ans;
			ans=scanner.next();
			if(!ans.equalsIgnoreCase("Yes"))
			{
				check=false;
			}
			
		}
		

	}

}
