/*
 * Created by Jasque Saydyk
 * Project 02 - Linked Lists, Stacks, and Queues
 * CS 249
 * 19 March 2017
 * Description - This class creates a doubly linked list that all classes
 * use to complete the project
*/
public class LinkedList<T> implements ILinkedList<T>{
	
	private INode<T> head;
	private INode<T> tail;
	private int size;
	
	
	/**
	 * Default constructor for a LinkedList
	 */
	public LinkedList(){
		size = 0;
		head = null;
		tail = null;
	}
	
	
	 /** 
	  * Appends the specified element at the given index.  The index of all
      * elements at index or later is increased.
      * Throws an IndexOutOfBoundsException when index is out of range.
      * @param e - The data to be stored in the node
      * @param index - The index in the list for the data to be stored
      */
	@Override
	public void add(T e, int index) {
		// If invalid index entry
		if(index < 0){
			throw new IndexOutOfBoundsException();
		}
		
		// Starting a new list 
		else if(size == 0){
			// At the beginning
			if(index == 0){
				head = new INode<>(null, null, e);
				size++;
			}
			
			// The second spot
			else if(index == 1){
				head = new INode<>(null, null, null);
				tail = new INode<>(head, null, e);
				head.setNext(tail);
				size++;
				size++;
			}
			
			// Beyond
			else{
				head = new INode<>(null, null, null);
				tail = new INode<>(head, null, null);
				head.setNext(tail);
				size++;
				size++;
				// Make empty nodes till you get to the desired index
				for(int ii = size; ii < index; ii++){
					INode<T> newNode = new INode<>(tail, null, null);
					tail.setNext(newNode);
					tail = newNode;
					size++;
				}
				// Loop ends at index to insert object
				INode<T> newNode = new INode<>(tail, null, e);
				tail.setNext(newNode);
				tail = newNode;
				size++;
			}
		}
		
		// If new item is to be put at the end of the list
		else if(size == index){
			// If there is only the head
			if(size == 1){
				tail = new INode<>(head, null, e);
				head.setNext(tail);
				size++;
			}
			// Otherwise, add at end of the list
			else{			
				INode<T> newNode = new INode<>(tail, null, e);
				tail.setNext(newNode);
				tail = newNode;
				size++;
			}
		}
		
		// If new item is to be put in slot bigger than already created list
		else if(size < index){
			// If there is only the head
			if(size == 1){
				tail = new INode<>(head, null, null);
				head.setNext(tail);
				size++;
			}
			
			// Make empty nodes till you get to the desired index
			for(int ii = size; ii < index; ii++){
				INode<T> newNode = new INode<>(tail, null, null);
				tail.setNext(newNode);
				tail = newNode;
				size++;
			}
			// Loop ends at index to insert object
			INode<T> newNode = new INode<>(tail, null, e);
			tail.setNext(newNode);
			tail = newNode;
			size++;
		}
		
		// Adding inside of list(push all numbers back, append to location)
		else if(size > index){
			// If appending to head with no tail
			if(index == 0 && size == 1){
				INode<T> newNode = new INode<>(null, head, e);
				head.setPrevious(newNode);
				tail = head;
				head = newNode;
				size++;
			}
			// If appending to head
			else if(index == 0){
				INode<T> newNode = new INode<>(null, head, e);
				head.setPrevious(newNode);
				head = newNode;
				size++;
			}
			// If appending in body
			else{
				// Find node, when found, add the node
				INode<T> current = head.next();
				for(int ii = 1; ii < size; ii++){
					if(ii == index){
						INode<T> newNode = new INode<>(current.previous(), current, e);
						current.previous.setNext(newNode);
						current.setPrevious(newNode);
						size++;
						break;
					}
					else{
						current = current.next();
					}
				}
			}
		}
		
		else{
			System.out.println("Something went wrong in adding to array!");
		}
	}

	
	/**
	 * Returns the element at the specified position in this list.
	 * Throws an IndexOutOfBoundsException when index is out of range.
	 * @param index - Location of node to get data from
	 * @return The element at the specified position
	 */
	@Override
	public T get(int index) {
		if(index < 0 || size == 0){
			throw new IndexOutOfBoundsException();
		}
		INode<T> current = getFirstNode();
		for(int ii = 0; ii != index; ii++){
			current = current.next();
		}
		return current.data();
	}

	
	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this list, or -1 if this list does not contain the element.
	 * @param e - Data to find index of in list
	 * @return The index of the first occurrence of the specified element
	 */
	@Override
	public int indexOf(T e) {
		INode<T> current = head;
		for(int ii = 0; ii < size; ii++){
			T data = current.data();
			if(e.equals(data)){
				return ii;
			}
			else{
				current = current.next();
			}
		}
		// Failed to find object
		return -1;
	}

	
	/**
	 * Removes the element at the specified position in this list.
	 * Throws an IndexOutOfBoundsException when index is out of range.
	 * @param index - Location of node to remove
	 * @return Data in removed node
	 */
	@Override
	public T remove(int index) {
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		// Remove from head
		else if(index == 0){
			INode<T> newHead = head.next();
			T data = head.data();
			head.next = null;
			head.data = null;
			//newHead.setPrevious(null);  // Only TestPopAfterPush stack test fails for some odd reason with line
			head = newHead;
			size--;
			return data;
		}
		// Remove from tail
		else if(index == size - 1){
			tail.previous().setNext(null);
			INode<T> oldTail = tail;
			tail = tail.previous();
			T data = oldTail.data();
			oldTail.setPrevious(null);
			oldTail.data = null;
			size--;
			return data;
		}
		// Remove from anywhere else in list
		else{
			// Finds node to remove
			INode<T> current = getFirstNode();
			for(int ii = 0; ii != index; ii++){
				current = current.next();
			}
			// Removes the node
			INode<T> before = current.previous();
			INode<T> after = current.next();
			before.setNext(current.next());
			after.setPrevious(current.previous());
			T data = current.data();
			current.next = null;
			current.previous = null;
			current.data = null;
			size--;
			return data;
		}
	}

	
	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 * Throws an IndexOutOfBoundsException when index is out of range.
	 * @param index - Location of node to set data
	 * @param element - Data to replace existing data in node
	 */
	@Override
	public void set(int index, T element) {
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		else{
			INode<T> current = head;
			for(int ii = 0; ii != index; ii++){
				current = current.next();
			}
			current.data = element;
		}
	}

	
	/**
	 * @return The number of elements in this list.
	 */
	@Override
	public int size() {
		return size;
	}
	
	
	/**
	 *  Returns this list in string form, surrounded by [] brackets and with each
     *  items separated by a comma and space.  For example:
     *  [First, Second, Third, Fourth]
     *  @return String representation of the data in LinkedList
     */
	public String toString(){
		INode<T> current = getFirstNode();
		String s = "[";
		for(int ii = 0; ii < size; ii++){
			s += current.data().toString();
			current = current.next();
			if(ii != size - 1){
				s += ", ";
			}
		}
		s += "]";
		return s;
	}
	

	/**
	 * Returns the first node object in the linked list, which should link to
	 * all of the linked nodes through next links.
	 * @return Head of LinkedList
	 */
	@Override
	public LinkedList<T>.INode<T> getFirstNode() {
		return head;
	}

	
	/**
	 * Returns the last node object in the linked list, which should link to all
	 * of the linked nodes through previous links.
	 * @return Tail of LinkedList
	 */
	@Override
	public INode<T> getLastNode() {
		if(size == 0 || size == 1){
			return head;
		}
		else{
			return tail;
		}
	}
	
	
	/**
	 * You must use an inner class in your implementation to implement this
	 * interface for the nodes.
	 */
	public class INode<E> implements ILinkedList.INode<T>{
		private INode<T> previous;
		private INode<T> next;
		private T data;
		
		
		/**
		 * Default Constructor to create a node
		 * @param previous - The previous node
		 * @param next - The next node
		 * @param data - The data to be stored in the node
		 */
		public INode(INode<T> previous, INode<T> next, T data){
			this.previous = previous;
			this.next = next;
			this.data = data;
		}
		
		
		/**
		 * @return The previous node, or null if this is the first node.
		 */
		@Override
		public INode<T> previous() {
			return this.previous;
		}
		
		
		/**
		 * Setter for node, not necessary, but habit makes if feel right
		 * @param previous - New node that previous will be set to
		 */
		public void setPrevious(INode<T> previous){
			this.previous = previous;
		}

		
		/**
		 * @return The next node, or null if this is the last node.
		 */
		@Override
		public INode<T> next() {
			return this.next;
		}
		
		
		/**
		 * Setter for node, not necessary, but habit makes if feel right
		 * @param next - New node that next will be set to
		 */
		public void setNext(INode<T> next){
			this.next = next;
		}

		
		/**
		 * @return - The element contained in this node
		 */
		@Override
		public T data() {
			if(this.data == null){
				T s = null;
				return s;
			}
			return this.data;
		}		
	}
}
