
public class Excercise2 {
	

	public static void main(String[] args) {
		DynamicArray da =new DynamicArray();
		LinkedList ll1 =new LinkedList("Rick");
		LinkedList ll2 =new LinkedList("Steve");
		LinkedList ll3=new LinkedList("Abey");
		LinkedList ll4 =new LinkedList("Lina");
		LinkedList ll5 =new LinkedList("Chaitanya");
//		LinkedList ll6 =new LinkedList("e");
		da.add(ll1);
		da.add(ll2);
		da.add(ll3);
		da.add(ll4);
		da.add(ll5);
//		da.add(ll6);
		da.quickSort(0, da.getSize()-1);
		da.printKeys();
		
		LinkedList[] arrayLnked =new LinkedList[2];
		arrayLnked[0]=new LinkedList("acr");
	
		arrayLnked[0].insertAtEnd(new Node ("abg"));
		arrayLnked[0].insertAtEnd(new Node ("abc"));
		arrayLnked[0].insertAtEnd(new Node ("abl"));
		arrayLnked[0].insertAtEnd(new Node ("aba"));
//		
		arrayLnked[0].insertAtEnd(new Node ("abb"));
//		
		arrayLnked[0].insertionSort();
		
		arrayLnked[1]=new LinkedList("abr");
		arrayLnked[1].insertAtEnd(new Node ("car"));
		arrayLnked[1].insertAtEnd(new Node ("arc"));
		arrayLnked[1].insertAtEnd(new Node ("rac"));
		arrayLnked[1].insertionSort();
		
//		ll.print();
		System.out.println("Rick".compareTo("Lina")>0);
	}

}
