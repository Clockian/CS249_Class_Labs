/**
 * @author Jasque Saydyk
 * CS 249: Lab 0 - Java Review
 * Description - Creates a bag that wraps an ArrayList, using Ithing generic, implementing IBag.
 * Skeleton of code provided by CS 249 class
 */
import java.util.ArrayList;

public class Bag<Ithing> implements IBag<IThing>{

	private ArrayList <IThing> bag;
	private double maxCapacity;
	
	/**
	 * Initialize the container with the specified capacity (capacity is specified
	 * in grams; the sum of the masses of the things in the container may not
	 * exceed the capacity).
	 * @param maxCapacity the amount of weight in grams the bag can hold
	 */
	@Override
	public void create(double maxCapacity) {
		bag = new ArrayList<IThing>();
		this.maxCapacity = maxCapacity;
	}

	/**
	 * Insert a thing into the container. Throw a new OutOfSpaceException if the
	 * container does not have enough remaining capacity to allow the thing to be inserted.
	 * @param thing any object that implements IThing
	 */
	@Override
	public void insert(IThing thing) throws Exception {
		
		if((this.getMass() + thing.getMass()) > maxCapacity){
			throw new OutOfSpaceException("No more space in bag");
		}
		else{
			bag.add(thing);
		}
	}

	/**
	 * Remove and return any one of the things in the container. Throw a new
	 * EmptyContainerException if the container does not contain anything to remove.
	 * @return thing the IThing removed from the bag
	 */
	@Override
	public IThing remove() throws Exception {
		if(bag.size() == 0){
			throw new EmptyBagException("There is nothing to remove");
		}
		IThing thing = bag.get(bag.size()-1);
		bag.remove(bag.size()-1);
		return thing;
	}

	/**
	 * Return the sum of the masses of the items in the container
	 * @return totalMass the sum of the masses in the bag in grams
	 */
	@Override
	public double getMass() {
		double totalMass = 0.0;
		
		// For each item in bag, get mass and add to totalMass
		for(IThing item : bag){
			totalMass = totalMass + item.getMass();
		}
		
		return totalMass;
	}

	/**
	 * Return the remaining capacity of the bag (in grams)
	 * @return the remaining capacity of the bag in grams
	 */
	@Override
	public double getRemainingCapacity() {
		return (maxCapacity - this.getMass());
	}
	
	/**
	 * Return a String description of the container that is the word 'Container:\n'
	 * followed by the concatenation of the String representation of each item in
	 * the container on separate lines:
	 * Bag:
	 * A green duck with a mass of 1028.3 grams
	 * This is a blue Jedi in a bag
	 * @return the string representation of each object in the bag
	 */
	public String toString(){
		String output = "Bag:\n";
		for(IThing item : bag){
			output = output + item.toString() + "\n";
		}
		return output;
	}
	
}