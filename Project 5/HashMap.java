/*
 * Created by Jasque Saydyk
 * Project 05 - Hash Tables
 * CS 249
 * 30 April 2017
 * Description - This class creates a HashMap
*/
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class HashMap<K, E> implements IMap<K, E>{

	ArrayList<IMapPair<K, E>> hashArray;
	int size;
	int max_size;
	
	// Ensure you have a constructor that takes an integer for the expected
    // number of items to be added to the Map.  The size of your internal array
    // and load metrics will be based on this expected size.
	public HashMap(int expected_size){
		size = 0;
    	max_size = expected_size;
    	hashArray = new ArrayList<>(expected_size);
    	
    	// Fill hashArray with null values, else data wouldn't be able to be initially set at indexes
    	for(int ii = 0; ii < expected_size; ii++){
    		hashArray.add(null);
    	}
	}
	
    // creates a key element pair and adds it into the hash array.
	@Override
	public void put(K key, E element) {
		// Get the hash value using the element
		int hashValue = key.hashCode();
		hashValue = Math.floorMod(hashValue, max_size);
		
		// Set variables to IMapClass
		IMapPair<K, E> store = new IMapPair<>(key, element);
		
		// If index is filled, run through LinkedList until null, then store
		IMapPair<K, E> current = hashArray.get(hashValue);
		if(current != null){
			while(current.next() != null){
				current = current.next();
			}
			// When it hits a null node, it sets it to store
			current.next = store;
		}
		// Set value to index value
		else{
			hashArray.set(hashValue, store);
			size++;
		}
	}

	// Retrieves an element from the hash array based on the key.
    // throws a NoSuchElementException if no such key exists.
	@Override
	public E get(K key) {
		// Get the hash value using the element
		int hashValue = key.hashCode();
		hashValue = Math.floorMod(hashValue, max_size);
		
		// Go to index in hashArray and check the key
		IMapPair<K, E> current = hashArray.get(hashValue);
		while(current != null){
			if(current.getKey().equals(key)){
				return current.getElement();
			}
			// If fails, continue down the linked list
			current = current.next();
		}
		// Unable to find item
		throw new NoSuchElementException();
	}

	// Returns the number of elements in this list.
	@Override
	public int size() {
		return size;
	}
	
	// Returns this list in string form, surrounded by [] brackets and with each
    // items separated by a comma and space.  For example:
    // [First, Second, Third, Fourth]
    public String toString(){
    	String s = "[";
    	for(IMapPair<K, E> pair: hashArray){
    		if(pair != null){
    			s += pair.toString();
        		s += ", ";
        		while(pair.next() != null){
        			pair = pair.next();
        			s += pair.toString();
            		s += ", ";
        		}
    		}
    	}
    	if(s.length() > 1){
    		s = s.substring(0, s.length() - 2);
    	}
    	s += "]";
    	return s;
    }

	@Override
	public Object[] getInternalArray() {
		Object[] arr = hashArray.toArray(new Object[hashArray.size()]);
		return arr;
	}
	
	
	public class IMapPair<Key, Element> implements IMap.IMapPair<K, E>{
		private K key;
		private E element;
		private IMapPair<Key, Element> next = null;
		
		public IMapPair(K key, E element){
			this.key = key;
			this.element = element;
		}
		
		// Retrieves the key for this pair.
		public K getKey(){
			return this.key;
		}

		// Retrieves the element corresponding to the key.
		public E getElement(){
			return this.element;
		}

		// This should return the next pair with a hash collision.
		public IMapPair<Key, Element> next(){
			return this.next;
		}

		// Returns this pair as a combination between keys and elements in the
		// following form:
		// Key: Element
		// where Key and Element are determined based on the toString of those
		// parts.
		public String toString(){
			String s = key.toString() + ": " + element.toString();
			return s;
		}

    }

}
