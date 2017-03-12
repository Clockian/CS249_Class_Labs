/**
 * @author Jasque Saydyk
 * CS 249: Lab 0 - Java Review
 * Description - Creates an Apple that has a color and a mass.
 * Skeleton of code provided by CS 249 class
 */
public class Apple implements IThing
{
  private String color;
  private double mass;
  
  /**
   * Constructs apple with a color and mass
   * @param color the color of the apple
   * @param mass the mass of the apple in grams
   */
  public Apple(String color, double mass)
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
   * The takeBite() method should reduce the mass of the apple it 10.0g
   * bites.  However, consider the apple core to be 25.0g and not edible,
   * meaning that regardless of the number of attempted bites taken out
   * of an apple, its mass should never go below 25.0g.
   */
  @Override
  public void takeBite() throws Exception {
	  double appleCore = 25.0;
	  double bite = 10.0;
	  
	  if(this.mass > appleCore && this.mass < (appleCore + bite)){
		  this.mass = appleCore;
	  }
	  else if((this.mass - bite) < appleCore){
		  throw new InedibleException("You can't eat the core of the apple");
	  }
	  else{
		  this.mass = this.mass - bite;
	  }
  }
  
  /**
   * This returns a String representation of the apple object according to
   * the following format: 'A <color> apple with a mass of <mass> grams'
   * @return String describing the apple object
   */
  public String toString()
  {
      return ("A " + color + " apple with a mass of " + mass + " grams");
  }
}
