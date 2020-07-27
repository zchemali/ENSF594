import java.util.Scanner;

public class MoneyChange {
	/**
	 * This method finds min number of coins needed for an int m
	 * @param m passed from main user input 
	 * @return
	 */

	public static void minCoins(int m) {
		int temp=m;
		int count10 = 0;
		int count5 = 0;
		int count1 = 0;
		//takes all the 10s
		while (true) {
			if ((m - 10) >= 0) {
				count10 += 1;
				m -= 10;
			} else {
				break;
			}
		}
		//takes all the 5s
		while (true) {
			if ((m - 5) >= 0) {
				count5 += 1;
				m -= 5;
			} else {
				break;
			}
		}
		//takes the remainder as 1s
		while (true) {
			if ((m - 1) >= 0) {
				count1 += 1;
				m -= 1;
			} else {
				break;
			}
		}
		System.out.println("m is "+temp+"\n10 coin: "+count10+"\n5 coin: "+count5+"\n1 coin: "+count1);

	}
	
	
	public static void main(String[] args) {
		
		
		Scanner scanner =new Scanner(System.in);
		boolean check=true;
		int m = 0;
		//loop that grabs user input and check if it is valid
		while (check) {
			System.out.println("Enter single integer m between 1 and 10^3");
			m=scanner.nextInt();
			if(m>=1 && m<Math.pow(10, 3))
				check=false;
			else
			System.out.println("Enter a valid number");
			
		}
		MoneyChange.minCoins(m);
	

	}

}
