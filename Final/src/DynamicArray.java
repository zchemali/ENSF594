
public class DynamicArray {
	
	LinkedList[] arrayLinked=new LinkedList [1];
	int size=1;
	public void add(LinkedList ll) {
		if(arrayLinked[size-1]==null)
		arrayLinked[size-1]=ll;
		else {
			size++;
			LinkedList[] temp =new LinkedList [size];
			for (int i=0;i<arrayLinked.length;i++) {
				temp[i]=arrayLinked[i];
				
			}
			arrayLinked=temp;
			arrayLinked[size-1]=ll;
		}
	}
	public void printKeys() {
		for(int i=0; i<arrayLinked.length;i++) {
			System.out.println(arrayLinked[i].getKey());
		}
	}
	
	public void quickSort(int low, int high) {
		if(low<high) {
			int index =partition( low, high);
			if(index>0 && index<=high)
			{quickSort(low, index-1);
			quickSort( index+1, high);}
		}
		
	}
	public int partition ( int low, int high) {
		LinkedList pivot =arrayLinked[high];
		int i=low;// i is the last element that swapping has occured 
		for (int j = low; j < high; j++) {
			if (arrayLinked[j].getKey().compareTo(pivot.getKey()) < 0) {

				LinkedList temp = arrayLinked[j];
				arrayLinked[j] = arrayLinked[i];
				arrayLinked[i] = temp;
				i++;

			}
		}
			//swapping the pivot with the element at i
		LinkedList temp = arrayLinked[i]; 
	        arrayLinked[i] = pivot; 
	        arrayLinked[high] = temp; 
		return i;
		
	}
	public int getSize() {
		return arrayLinked.length;
	}
	
}
