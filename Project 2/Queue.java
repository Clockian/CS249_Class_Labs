/*
 * Created by Jasque Saydyk
 * Project 02 - Linked Lists, Stacks, and Queues
 * CS 249
 * 19 March 2017
 * Description - This class creates a queue using the LinkedList class
*/
import java.util.NoSuchElementException;

public class Queue<E> implements IQueue<E>{

	LinkedList<E> queue;
	int counter;
	
	
	/**
	 * Default constructor for Queue
	 */
	public Queue(){
		queue = new LinkedList<E>();
		counter = 0;
	}
	
	
	/** 
	 * Adds an element onto the queue.
	 * @param e - Object to be added to the end of the queue
	 */
	@Override
	public void push(E e) {
		queue.add(e, counter);
		counter++;
	}

	
	/** 
	 * Removes and returns the oldest element in the queue.
     * Throws a NoSuchElementException if the queue is empty.
     * @return The oldest element in the queue and removes it
     */
	@Override
	public E pop() {
		if(counter <= 0){
			throw new NoSuchElementException();
		}
		counter--;
		return queue.remove(0);
	}

	
	/** 
	 * Returns the oldest item in the queue without removing it.
     * Throws a NoSuchElementException if the queue is empty.
     * @return The oldest item in the queue without removing it
     */
	@Override
	public E peek() {
		if(counter <= 0){
			throw new NoSuchElementException();
		}
		return queue.get(0);
	}

	
	/** 
	 * Returns the number of elements in this queue.
	 * @return Size of the queue
	 */
	@Override
	public int size() {
		return counter;
	}
	
	
	/** 
	 * Returns this queue in string form, surrounded by [] brackets and with
     * each items separated by a comma and space.  For example:
     * [First, Second, Third, Fourth]
     * where 'First' is the next item that would be returned by pop()
     * @return String representation of the data in the queue
     */
    public String toString(){
    	String s = "[";
		for(int ii = 0; ii < counter; ii++){
			s += queue.get(ii).toString();
			if(ii < counter - 1){
				s += ", ";
			}
		}
		s += "]";
    	return s;
    }

    
    /**
     * @return The linked list which this queue is composed over
     */
	@Override
	public ILinkedList<E> getInternalLinkedList() {
		return queue;
	}
}
