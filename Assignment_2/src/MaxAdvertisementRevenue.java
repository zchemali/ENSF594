import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaxAdvertisementRevenue {
	int[] a;
	int[] b;
	int n;
	public MaxAdvertisementRevenue(int n) {
		Scanner scanner =new Scanner(System.in);
		this.n=n;
		a=new int[n];
		b=new int [n];
		
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
		Arrays.sort(a);
		Arrays.sort(b);
		double sum=0;
		for (int i=0;i<n;i++){
			sum+=a[i]*b[i];
		}
		System.out.println("Max ad revenue "+sum);
	}

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int temp_n=0;
		boolean check=true;
		while (check) {
			System.out.println("Enter number of ads between 1 and 10^3");
			temp_n=scanner.nextInt();
			if(temp_n>=1 && temp_n<Math.pow(10, 3))
				check=false;
			else
			System.out.println("Enter a valid number");
			
		}
		new MaxAdvertisementRevenue(temp_n);
	}

}
