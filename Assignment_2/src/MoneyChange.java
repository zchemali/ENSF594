
public class MoneyChange {

	public static int minCoins(int m) {
		int count10 = 0;
		int count5 = 0;
		int count1 = 0;
		while (true) {
			if ((m - 10) >= 0) {
				count10 += 1;
				m -= 10;
			} else {
				break;
			}
		}
		while (true) {
			if ((m - 5) >= 0) {
				count5 += 1;
				m -= 5;
			} else {
				break;
			}
		}
		while (true) {
			if ((m - 1) >= 0) {
				count1 += 1;
				m -= 1;
			} else {
				break;
			}
		}
		System.out.println("m is "+m+"\n10 coin: "+count10+"\n5 coin: "+count5+"\n1 coin: "+count1);
		return count10 + count5 + count1;

	}
	
	
	public static void main(String[] args) {
		
		MoneyChange.minCoins(999);
	
		// TODO Auto-generated method stub

	}

}
