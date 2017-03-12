/**
 * @author Jasque Saydyk
 * CS 249: Lab 0 - Java Review
 * Description - Creates an Apple that has a color and a mass.
 * Skeleton of code provided by CS 249 class
 */
public class Duck implements IThing
{
  private String color;
  private double mass;
  
  /**
   * Constructs apple with a color and mass
   * @param color the color of the apple
   * @param mass the mass of the apple in grams
   */
  public Duck(String color, double mass)
  {
	  this.color = color;
	  this.mass = mass;
  }

  /**
   * Returns color of apple
   * @return color of apple as a String
   */
  @Override
  public String getColor() {
	  return color;
  }

  /**
   * Returns mass of apple
   * @return mass of apple as a double in grams
   */
  @Override
  public double getMass() {
	  return mass;
  }

  /**
   * You shouldn't be able to take a bite of of a duck, so the
   * the takeBite() method should throw a new QuackException.
   * @throws QuackException you can't bite a duck
   */
  @Override
  public void takeBite() throws Exception {
	  throw new QuackException("You can't bite a duck");
  }

  /**
   * This returns a String representation of the duck object according to
   * the following format: 'A <color> duck with a mass of <mass> grams'
   * @return String describing the duck object
   */
  public String toString()
  {
      return ("A " + color + " duck with a mass of " + mass + " grams");
  }
}
