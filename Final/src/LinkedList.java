
/**
 * This class creates a singleLinked list, this is done by using Node class
 * 
 * @author zchem
 *
 */
public class LinkedList {
	Node head;// creating the head pointer of the node
	int i = 0;// size
	String key;// key this is the alphabetical order of characters of each word in text file

	/**
	 * getter for key
	 * 
	 * @return
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Constructor that sets the key to the passed parameter
	 */
	public LinkedList(String key) {
		this.key = key;
	}

	/**
	 * getter for size of linked list
	 * 
	 * @return
	 */
	public int getSize() {
		return i;
	}

	/**
	 * This function adds another node at the end of the linkedlist
	 * 
	 * @param n
	 */
	public void insertAtEnd(Node n) {
		// checks if head is null and sets it to node if it is
		if (head == null) {
			head = n;
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
	 * Temp Node that goes through all nodes and appends their values (words) into a
	 * string buffer
	 * 
	 * @return String of all the elements in the linkedList
	 */
	public String print() {
		StringBuffer sb = new StringBuffer();
		Node temp = head;
		while (temp != null) {
			sb.append(temp.getWord() + "  ");
			temp = temp.next;

		}
		return sb.toString();

	}

	/**
	 * This fucntion returns the node previous to the parameter passed
	 * 
	 * @param n
	 * @return previous Node
	 */
	public Node getPrevious(Node n) {

		Node temp = head;
		while (temp.next != null) {
			if (temp.next == n)
				return temp;
			else
				temp = temp.next;
		}

		return null;
	}

	/**
	 * This function applies the insertion sort algorithm and sorts the entire
	 * linkedList
	 */
	public void insertionSort() {
		Node temp = head.next;
		while (temp != null) {
			String word = temp.getWord();
			Node temp2 = getPrevious(temp);

			while (temp2 != null) {
				String word2 = temp2.getWord();
				if (word2.compareToIgnoreCase(word) > 0) {
					temp2.next.setWord(word2);
					temp2.setWord(word);
				}
				temp2 = getPrevious(temp2);
			}
			temp = temp.next;

		}
	}

}
