
/**
 * This is where the methods for inserting/deleteing a node are.
 * 
 * @author zchem
 *
 */
public class LinkedList {
	Node head;// creating the head pointer of the node
	int i = 0;// size
	String key;

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * 
	 * @return the size of the list
	 */
	public LinkedList(String key) {
		this.key=key;
	}
	public int getSize() {
		return i;
	}

	
	public void insertAtEnd(Node n) {
		// checks if head is null and sets it to node if it is
		if (head == null) {
			head = n;
//			System.out.println("This is head");
			i = 1;
			n.setId(0);
		} else

		{
			// gets the last node that was created and sets its next to the new node n
			getLastNode().next = n;
			n.setId(i);
			i++;
		}

	}

	/**
	 * Creates a temp pointer that checks each next and returns the pointer where
	 * the next is null
	 * 
	 * @return the last node created
	 */
	private Node getLastNode() {
		Node pointer = head;

		while (pointer.next != null) {
			pointer = pointer.next;
		}
		return pointer;
	}

	/**
	 * Temp Node that goes through all nodes and prints their values
	 */
	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.println("ID: "+temp.getId()+" Word "+temp.getWord());
			temp = temp.next;

		}
		
	}
	public Node getPrevious(Node n) {
		
		Node temp = head;
		while (temp.next != null) {
			if(temp.next == n)
				return temp;
				else 
					temp=temp.next;
				}
			
		return null;
	}
	
	
	
	public void insertionSort () {
		Node temp = head.next;
		while (temp != null ) {
			String word=temp.getWord();
			Node temp2=getPrevious(temp);

			while( temp2!=null) {
				String word2=temp2.getWord();
//				System.err.println("Word1  : "+word2+" word 2: "+word);
				if(word2.compareToIgnoreCase(word)>0) {
					temp2.next.setWord(word2);
					temp2.setWord(word);
//					System.err.println(temp.getWord());
				}
				temp2=getPrevious(temp2);
			}
			temp=temp.next;

		}}
		
		
}
	