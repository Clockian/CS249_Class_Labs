/*
 * Created by Jasque Saydyk
 * Project 05 - Hash Tables
 * CS 249
 * 30 April 2017
 * Description - This class creates a HashSet
*/
import java.util.ArrayList;

public class HashSet<E> implements ISet<E>{

	ArrayList<E> hashArray;
	int size;
	int max_size;
	
    // Ensure you have a constructor that takes an integer for the expected
    // number of items to be added to the Map.  The size of your internal array
    // and load metrics will be based on this expected size.
    public HashSet(int expected_size){
    	size = 0;
    	max_size = expected_size;
    	hashArray = new ArrayList<>(expected_size);
    	
    	// Fill hashArray with null values, else data wouldn't be able to be initially set at indexes
    	for(int ii = 0; ii < expected_size; ii++){
    		hashArray.add(null);
    	}
    }
	
	// Adds an element into the set.  Should there be a collision with an
    // existing element, use double hashing. To perform this double hashing
    // convert your hash into a string and retrieve that string's hash.
	@Override
	public void add(E element) {
		// Get the hash value using the element
		int hashValue = element.hashCode();
		hashValue = Math.floorMod(hashValue, max_size);
		
		// Get the double hash value for the element
		String elementString = element.toString();
		int doubleHashValue = Math.abs(elementString.hashCode());
		int i = 0;
		
		// Run through hashArray till you get to specified index
		while(hashArray.get(hashValue) != null){
			hashValue += doubleHashValue;  // Add the step
			hashValue %= max_size;  // For wrap-around
			hashValue = Math.abs(hashValue);
			if(i > 2){
				hashValue++;
			}
			i++;
		}
		// Set value to index value
		hashArray.set(hashValue, element);
		size++;
	}

	// returns true if the provided item has already been added.
	@Override
	public boolean has(E element) {
		// Get the hash value using the element
		int hashValue = element.hashCode();
		hashValue = Math.floorMod(hashValue, max_size);
		
		// Get the double hash value for the element
		String elementString = element.toString();
		int doubleHashValue = elementString.hashCode();
		
		// Run through hashArray till you get to specified index
		while(hashArray.get(hashValue) != null){
			if(hashArray.get(hashValue).equals(element)){
				return true;
			}
			hashValue += doubleHashValue;  // Add the step
			hashValue %= max_size;  // For wrap-around
		}
		// Unable to find item
		return false;
	}

	// Returns the number of elements added to the set.
	@Override
	public int size() {
		return size;
	}
	
	// Returns this list in string form, surrounded by [] brackets and with each
    // items separated by a comma and space.  For example:
    // [Thing, Other, Object, Entry]
    // you should output them in the order of the internal representation.
    public String toString(){
    	String s = "[";
    	for(E element: hashArray){
    		if(element != null){
    			s += element;
        		s += ", ";
    		}
    	}
    	s = s.substring(0, s.length() - 2);
    	s += "]";
    	return s;
    }

    // Returns the internal array used to store the hash table.
    // Note: This returns an Object[] array as creating an array using the
    // generic placeholder type  E is not supported by java.  None the
    // less, this array must be populated with objects of class E.
	@Override
	public Object[] getInternalArray() {
		Object[] arr = hashArray.toArray(new Object[hashArray.size()]);
		return arr;
	}

}
