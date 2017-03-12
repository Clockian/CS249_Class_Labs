/**
 * An generic interface declaring what it means to be a bag.
 */
public interface IBag<E>
{
  /**
   * Initialize the container with the specified capacity (capacity is specified
   * in grams; the sum of the masses of the things in the container may not
   * exceed the capacity).
   */
  public void create(double maxCapacity);

  /**
   * Insert a thing into the container. Throw a new OutOfSpaceException if the
   * container does not have enough remaining capacity to allow the thing to be inserted.
   */
  public void insert(E thing) throws Exception;

  /**
   * Remove and return any one of the things in the container. Throw a new
   * EmptyContainerException if the container does not contain anything to remove.
   */
  public E remove() throws Exception;

  /**
   * Return the sum of the masses of the items in the container
   */
  public double getMass();

  /**
   * Return the remaining capacity of the bag (in grams)
   */
  public double getRemainingCapacity();

  /**
   * Return a String description of the container that is the word 'Container:\n'
   * followed by the concatenation of the String representation of each item in
   * the container on separate lines:
   *
   * Bag:
   * A green duck with a mass of 1028.3 grams
   * A red apple with a mass of 180.61 grams
   * This is a String in a bag
   * This is a blue Jedi in a bag
   *
   */
  public String toString();
}
