 import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
//import java.util.stream
public class MaxLoot {
	Integer [] valueWeight1,valueWeight2,valueWeight3;
	HashMap<Integer,Integer[]> input,result;
	HashMap<Double,Integer> ratio;
	
	
	int elements,maxWeight;

	public MaxLoot(int elements,int maxWeight) {
		Scanner scanner =new Scanner(System.in);
		input=new HashMap<Integer, Integer[]>();
		ratio=new HashMap<Double, Integer>();
		this.elements=elements;
		this.maxWeight=maxWeight;
		for (int i=0;i<elements;i++) {
			Integer[] valueWeight=new Integer[2];
			boolean check =true;
			while(check) {
			System.out.println("Enter value for element "+ (i+1));
			valueWeight[0]=scanner.nextInt();
			System.out.println("Enter weight for element "+ (i+1));
			valueWeight[1]=scanner.nextInt();
			if((valueWeight[0]>=0 && valueWeight[0]<2*Math.pow(10, 6)) && (valueWeight[1]>=0 && valueWeight[1]<2*Math.pow(10, 6)))
				{input.put((i+1),valueWeight);
			ratio.put( (double) (valueWeight[0]/valueWeight[1]),(i+1));
			check=false;}
				
			else
				System.out.println("Enter a valid number");
			}
			
		}
		
		result=findCombination(maxWeight,input,ratio);
		
		for (int i=0 ;i <result.size();i++) {
			System.out.println(result.get(i+1)[1]+" of the element that has a value of "+result.get(i+1)[0]);
		}
		
		
		
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
			tempList=input2.get(key);
			if(maxWeight2>=tempList[1]) {
				maxWeight2-=tempList[1];
				sum+=tempList[0];
				ratioList.remove(0);
				result.put(i,tempList);
			}
			else {
				sum+=(double)(maxWeight2)/(tempList[1])*tempList[0];
				System.err.println((double)(maxWeight2)/(tempList[1])*tempList[0]);
				tempList[1]=maxWeight2;
				result.put(i, tempList);
				maxWeight2=0;
			}
			
		}
		DecimalFormat df =new DecimalFormat(".####");
		System.out.println("Max Sum is "+df.format(sum));
		return result;
	}
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int temp_elements= 0;
		int temp_weight=0;
		boolean check=true;
		while (check) {
			System.out.println("Enter number of elements between 1 and 10^3");
			temp_elements=scanner.nextInt();
			System.out.println("Enter max capacity between 0 and 2.10^6");
			temp_weight=scanner.nextInt();
			if((temp_elements>=1 && temp_elements<Math.pow(10, 3)) && (temp_weight>=0 && temp_weight<2*Math.pow(10, 6)) )
				check=false;
			else
			System.out.println("Enter a valid number");
			
		}
		new MaxLoot(temp_elements,temp_weight);
	}
	
}
