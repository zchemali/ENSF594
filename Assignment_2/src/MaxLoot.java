 import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
//import java.util.stream
import java.util.stream.IntStream;
public class MaxLoot {
	Integer [] valueWeight1,valueWeight2,valueWeight3;
	HashMap<Integer,Integer[]> input,result;
	HashMap<Double,Integer> ratio;
	
	int elements,maxWeight;

	public MaxLoot() {
		elements=3;
		maxWeight=60;
		valueWeight1=new Integer[2];
		valueWeight2=new Integer[2];
		valueWeight3=new Integer[2];
		input=new HashMap<Integer, Integer[]>();
		ratio=new HashMap<Double, Integer>();
		valueWeight1[0]=60;
		valueWeight1[1]=20;
		input.put(1, valueWeight1);
		ratio.put( (double) (valueWeight1[0]/valueWeight1[1]),1);
		valueWeight2[0]=100;
		valueWeight2[1]=50;
		input.put(2, valueWeight2);
		ratio.put( (double) (valueWeight2[0]/valueWeight2[1]),2);
		valueWeight3[0]=120;
		valueWeight3[1]=30;
		input.put(3, valueWeight3);
		ratio.put( (double) (valueWeight3[0]/valueWeight3[1]),3);
		
		result=findCombination(maxWeight,input,ratio);
		for (int i=1 ;i <result.size();i++) {
			System.out.println(result.get(i)[1]+" of the element of value "+result.get(i)[0]);
		}
		// TODO for loop to keep geting elemnts and their weights
		
		
		
	}
	private HashMap<Integer, Integer[]> findCombination(int maxWeight2, HashMap<Integer, Integer[]> input2, HashMap<Double, Integer> ratio2) {
		
		Set<Double> tempSet=ratio.keySet();
		ArrayList<Double> ratioList=new ArrayList<Double>();
		ratioList.addAll(tempSet);
		Collections.sort(ratioList,Collections.reverseOrder());
		result=new HashMap<Integer, Integer[]>();
		double sum=0;
		Integer[] tempList;
		int i=0;
		while(maxWeight2!=0) {
			i++;
			Double temp =ratioList.get(0);
			
			Integer key =ratio.get(temp);
//			System.out.println(" key is "+key);
			tempList=input2.get(key);
//			System.out.println(" Temp lis  insx 0 is  "+tempList[1]);
			if(maxWeight2>=tempList[1]) {
				maxWeight2-=tempList[1];
//				System.out.println("sum before"+ sum);
				sum+=tempList[0];
				ratioList.remove(0);
				result.put(i,tempList);
				
//				System.out.println("sum after"+ sum);
//				System.out.println(ratioList.get(0));
				
				
				
			}
			else {
				
//				
				sum+=(tempList[1]-maxWeight2)/(tempList[1])*tempList[0];
//				System.out.println((tempList[1]-maxWeight2)/(tempList[1])*tempList[0]);
				tempList[1]=tempList[1]-maxWeight2;
				result.put(i, tempList);
				maxWeight2=0;
			}
			
			
		}
		System.out.println(sum);
		return result;
	}
	public static void main(String[] args) {
		// TODO for loop to keep geting elemnts and their weights
		new MaxLoot();
////		MaxLoot loot =new MaxLoot();
//		loot.elements=3;
//		loot.maxWeight=10;
//		
//		loot.value[0]=500;
////		loot.value[1]=100;
////		loot.value[2]=120;
//		loot.weight[0]=30;
////		loot.weight[1]=50;
////		loot.weight[2]=30;
//		loot.input=n
//		loot.comboGenerator(loot.w, loot.n, loot.weight);
		
//		loot.findCombo(loot.w,loot.value,loot.weight);

	}
	/**
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
		System.out.println(combos[0]+" combo 2   ");}*/

	
}
