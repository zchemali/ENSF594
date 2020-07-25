 import java.util.Arrays;
//import java.util.stream
import java.util.stream.IntStream;
public class MaxLoot {
	double[] value;
	double[] weight;
	int n,w;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxLoot loot =new MaxLoot();
		loot.n=1;
		loot.w=10;
		loot.value=new double[loot.n];
		loot.weight=new double[loot.n];
		loot.value[0]=500;
//		loot.value[1]=100;
//		loot.value[2]=120;
		loot.weight[0]=30;
//		loot.weight[1]=50;
//		loot.weight[2]=30;
//		loot.comboGenerator(loot.w, loot.n, loot.weight);
		
		loot.findCombo(loot.w,loot.value,loot.weight);

	}
	private double[] comboGenerator(int weight,int length,double[] weights) {
		double[] combo=new double[length];
		double sum =Arrays.stream(combo).sum();
		while (sum!=weight) {
			for (int i =0 ; i<combo.length;i++) {
				combo[i]=Math.round((Math.random()*weights[i]));
			}
			sum =Arrays.stream(combo).sum();
//			System.out.println(sum);
		}
		
//		for (int i =0 ; i<combo.length;i++) {
//			combo[i]=combo[i]/weights[i];}
		return combo;
	}
	


	private void findCombo(int weight, double[] values, double[] weights) {
		
		double total=0;
		
		double [] combos=new double[values.length];
		int t=6000;
		while (t>0) {
			double[] combo=comboGenerator(weight, values.length, weights);
			double temp=0;
			for (int i =0 ; i<combo.length;i++) {
				temp+=combo[i]*values[i]/weights[i];
			
		}	
			
			if(temp>total) {
				total=temp;
				combos=combo;
				System.out.println(total);
			}
			t--;
		
	}
		System.out.println(combos[0]+" combo 2   ");}

	
}
