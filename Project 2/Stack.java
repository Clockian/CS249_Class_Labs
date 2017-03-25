/*
 * Created by Jasque Saydyk
 * Project 02 - Linked Lists, Stacks, and Queues
 * CS 249
 * 19 March 2017
 * Description - This class creates a stack using the LinkedList class
*/
import java.util.NoSuchElementException;

public class Stack<E> implements IStack<E>{
	
	LinkedList<E> stack;
	int counter;
	
	
	/**
	 * Default constructor for Stack
	 */
	public Stack(){
		stack = new LinkedList<E>();
		counter = 0;
	}
	
	
	/** 
	 * Adds an element onto the stack.
	 * @param - Object to be added to the top of the stack
	 */
	@Override
	public void push(E e) {
		stack.add(e, 0);
		counter++;
	}

	
	/** 
	 * Removes and returns the most recent element added to the stack.
     * Throws a NoSuchElementException if the stack is empty.
     * @return The newest element in the stack and removes the node
     */
	@Override
	public E pop() {
		if(counter <= 0){
			throw new NoSuchElementException();
		}
		E data = stack.remove(0);
		counter--;
		return data;
	}

	
	/** 
	 * Returns the item on the top of the stack without removing it.
     * Throws a NoSuchElementException if the stack is empty.
     * @return The newest item in the stack without removing it
     */
	@Override
	public E peek() {
		if(counter <= 0){
			throw new NoSuchElementException();
		}
		return stack.get(0);
	}

	
	/** 
	 * Returns the number of elements in this stack.
	 * @return Size of the stack
	 */
	@Override
	public int size() {
		return counter;
	}
	
	
	/** 
	 * Returns this stack in string form, surrounded by [] brackets and with
     * each items separated by a comma and space.  For example:
     * [First, Second, Third, Fourth]
     * where 'First' is the next item that would be returned by pop()
     * @return String representation of the data in the stack
     */
    public String toString() {
    	String s = "[";
		for(int ii = 0; ii < counter; ii++){
			s += stack.get(ii).toString();
			if(ii < counter - 1){
				s += ", ";
			}
		}
		s += "]";
    	return s;
	}

    
    /**
     * @return The linked list which this stack is composed over
     */
	@Override
	public ILinkedList<E> getInternalLinkedList() {
		return stack;
	}
}
