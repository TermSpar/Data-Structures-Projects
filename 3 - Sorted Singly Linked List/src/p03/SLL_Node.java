package p03;

public class SLL_Node <T> {
	
	private T data;
	private SLL_Node<T> nextNode;
	
	public SLL_Node () {
		this.data = null;
		nextNode = null;
	}
	
	public SLL_Node(T data, SLL_Node<T> next) {
		this.data = data;
		nextNode = next;
	}
	
	public T getData () {
		return data;
	}
	
	public void setData (T data) {
		this.data = data;
	}
	
	public SLL_Node<T> getNext () {
		return nextNode;
	}
	
	public void setNext (SLL_Node<T> next) {
		nextNode = next;
	}
}