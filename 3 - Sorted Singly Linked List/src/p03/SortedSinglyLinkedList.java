package p03;

public class SortedSinglyLinkedList <T extends Number & Comparable <? super T>> {

	private SLL_Node <T> head;
	private int size;

	public SortedSinglyLinkedList () {
		// DO THIS
		// 	Initialize the head to be null and size to be 0
		head = null;
		size = 0;
	}

	public int getSize() {
		// DO THIS
		return size;
	}

	public void clearList() {
		// DO THIS
		size = 0;
		head = null;
		System.out.println("List has been cleared!\n");
	}
	
	//Add an SLL_Node to the list in the correct place -- ascending order of value and return true
	public void add(T x) {
		// DO THIS
		// if head already exists:
		if(head != null) {
			// create new node:
			SLL_Node <T> newNode = new SLL_Node(x, null);
			
			// find newNode's spot:
			SLL_Node <T> last = head;
			
			// if the head's data is greater than newNode's data:
			if(compare((T)head.getData(), (T)newNode.getData()) == 1) {
				// swap the values:
				newNode.setNext(head);
				head = newNode;
			}
			// but if everything is normal:
			else {
				// loop while the current iteration isn't last, and while it's less than newNode's data:
				while(last.getNext() != null && compare((T)last.getNext().getData(), (T)newNode.getData()) == -1) {
					last = last.getNext();
				}
				
				// set new node in its proper place:
				newNode.setNext(last.getNext());
				last.setNext(newNode);
			}
		}
		// if head does not yet exist, make it the first entry:
		else {
			head = new SLL_Node(x, null);
		}
		size++;
	}

	//Remove an SLL_Node from the list; if the value doesn't exist in the list returns false;
	public boolean remove(T x) {
		// DO THIS
		if(size == 0) { System.out.println("Your list is empty!\n"); return false; }
		
		SLL_Node previous = head;
		SLL_Node current = head.getNext();
		
		// if the head is to be deleted:
		if(compare((T)previous.getData(), x) == 0) {
			// set head to the original head's next value:
			head = previous.getNext();
			size--;
			System.out.println("'" + x + "' has been deleted!\n");
			return true;
		}
		
		// if somewhere else is to be deleted:
		while(current != null) {
			if(compare((T)current.getData(), x) == 0) {
				// set previous's next to current's next:, thereby cutting current off (deleting the desired):
				previous.setNext(current.getNext());
				size--;
				System.out.println("'" + x + "' has been deleted!\n");
				return true;
			}
			else {
				// otherwise, keep iterating:
				current = current.getNext();
				previous = previous.getNext();
			}
		}
		
		// if the number to be deleted isn't in the list:
		System.out.println("Data not found\n");
		return false;
	}

	public boolean find(T x) {
		SLL_Node current = head;
		int index = 0;
		// if item is in the list:
		while(current != null) {
			if(compare((T)current.getData(), x) == 0) {
				System.out.println("The value '" + x + "' is in the list!\n");
				return true;
			}
			else {
				current = current.getNext();
				index++;
			}
		}
		// otherwise:
		System.out.println("The value '" + x + "' is not in the list\n");
		return false;
	}
	
	private int compare(T n1, T n2) {
		return n1.compareTo(n2);
	}

	// Print out all nodes in the list
	public void print() {
		if(size != 0) {
			SLL_Node current = head;
			System.out.println("\nThe list is:");
			while(current != null) {
				System.out.print(current.getData() + " ");
				current = current.getNext();
			}
			System.out.println("\n");
		}
		else {
			System.out.println("Your list is empty!\n");
		}
	}
}