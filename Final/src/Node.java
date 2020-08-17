
/**
 * This is where nodes are created 
 * @author zchem
 *
 */
public class Node {
	//creating an next pointer of the node
Node next;
int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
String word;
// constructor to store the int and set the next pointer of the node to null
public Node (String word){
	this.word=word;
	next=null;
}
/////////////////// setters and getters////////////////////
public Node getNext() {
	return next;
}
public void setNext(Node next) {
	this.next = next;
}
public String getWord() {
	return this.word;
}
public void setWord(String word) {
	this.word = word;
}

}
