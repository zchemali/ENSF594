


import java.util.Arrays;
import java.util.Scanner;

public class MaxAdvertisementRevenue {
	//variables 
	int[] a;
	int[] b;
	int n;
	/**
	 * Constructor 
	 * @param n is the number of ads passed from main method
	 */
	public MaxAdvertisementRevenue(int n) {
		Scanner scanner =new Scanner(System.in);
		this.n=n;
		a=new int[n];
		b=new int [n];
		//for loop that fills a[] and checks if the user entry
		//is valid or not
		for (int i=0 ;i<n;i++) {
			boolean check=true;
			while (check) {
			System.out.println(" Enter profit per click  for  ad"+(i+1));
			int x=scanner.nextInt();
			if(x>= -1*Math.pow(10, 5) && x<=Math.pow(10, 5)) {
				a[i]=x;
				check=false;
			}
			else {
				System.out.println("Enter valid number");
			}
				
				
			}
		}
		//for loop that fills b[] and checks if the user entry
		//is valid or not
		for (int i=0 ;i<n;i++) {
			boolean check=true;
			while (check) {
			System.out.println(" Enter clicks per day for slot"+(i+1));
			int x=scanner.nextInt();
			if(x>= -1*Math.pow(10, 5) && x<=Math.pow(10, 5)) {
				b[i]=x;
				check=false;
			}
			else {
				System.out.println("Enter valid number");
			}
				
				
			}
		}
		//sorts the arrays
		Arrays.sort(a);
		Arrays.sort(b);
		double sum=0;
		//traversing through the arrays to calulate max sum
		for (int i=0;i<n;i++){
			sum+=a[i]*b[i];
		}
		System.out.println("Max ad revenue "+sum);
	}

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int temp_n=0;
		boolean check=true;
		//prompts user to enter number of ads, and checks if number is valid
		while (check) {
			System.out.println("Enter number of ads between 1 and 10^3");
			temp_n=scanner.nextInt();
			if(temp_n>=1 && temp_n<Math.pow(10, 3))
				check=false;
			else
			System.out.println("Enter a valid number");
			
		}
		//invoking th constructor
		new MaxAdvertisementRevenue(temp_n);
	}

}
