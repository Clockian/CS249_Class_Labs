/**
 * An interface that defines what it means to be a 'thing'.
 */
public interface IThing
{
  /**
   * Return a String representation of the color of the thing
   */
  public String getColor();

  /**
   * Return the mass of the thing (in grams)
   */
  public double getMass();

  /**
   * Try to take a bite out of the thing.
   */
  public void takeBite() throws Exception;
}
