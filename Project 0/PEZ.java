/**
 * A PEZ dispenser class.
 *
 * TODO: Make this class implement the Thing interface
 *
 * TODO: When implementing the Thing interface, the takeBite() method should
 * throw an inedibleException exception.  
 *
 * TODO: Implement the additional methods described below.
 */
public class PEZ implements IThing
{

  /**
   * TODO: Add any instance variables to the class that are needed and fill in
   * the following constructor accordingly.
   */
   private String color;
   private double mass = 1.0;
  public PEZ(String color)
  {
    this.color = color;
  }

  public void takeBite() throws InedibleException
  {
    throw new InedibleException();
  }

  public double getMass()
  {
    return mass;
  }

  public String getColor()
  {
    return color;
  }

  /**
   * This should return a String representation of the PEZ object according to
   * the following format:
   *
   * 'A <color> PEZ with a mass of <mass> grams'
   *
   * Ex:
   *   - A purple PEZ with a mass of 1.0 grams
   */
  public String toString()
  {
    return "A "+color+" PEZ with a mass of "+mass+" grams";
  }
}

