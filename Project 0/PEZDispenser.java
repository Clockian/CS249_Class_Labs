import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrick
 */
public class PEZDispenser<P extends PEZ> implements InnerContainer<P> {
    private String color;
    private double mass = 27.0;
    double capacity;
    ArrayList<P> list = new ArrayList<P>();
    
   
  /*
   * This section implements IThing
   */
  public PEZDispenser(String color)
  {
    this.color = color;
  }

  public void takeBite() throws InedibleException
  {
    throw new InedibleException();
  }

  public String getColor()
  {
    return color;
  }

  /*
   * Remaining code implements iBag
   */

  public void create(double maxCapacity)
  {
    capacity = maxCapacity;
  }

  public void insert(P candy) throws Exception
  {
    if(getRemainingCapacity() < candy.getMass()) throw new OutOfSpaceException();
    list.add(candy);
  }

  public P remove() throws Exception
  {
    if(list.size() == 0) throw new EmptyBagException();
    return list.remove(0);
  }

  public double getMass()
  {
    double mass = 0;
    for(int i = 0; i < list.size(); i++)
    {
      mass += list.get(i).getMass();
    }
    return mass + this.mass;
  }

  public double getRemainingCapacity()
  {
    return capacity-getMass();
  }

  public String toString()
  {
    String desc = "PEZ Dispenser:\n";
    for(int i = 0; i < list.size(); i++)
    {
      desc += ""+list.get(i)+"\n";
    }
    return desc;
  }

}
