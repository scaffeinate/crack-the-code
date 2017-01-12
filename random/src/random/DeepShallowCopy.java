package random;

import java.util.ArrayList;
import java.util.List;

/**
 * http://javaconceptoftheday.com/difference-between-shallow-copy-vs-deep-copy-in-java/
 * @author Sudharsanan Muralidharan
 */
public class DeepShallowCopy {
  public static void main(String[] args) throws CloneNotSupportedException {
    Vehicle v = new Vehicle();
    v.numWheels = 2;
    v.name = "Harley";
    v.color = "Black";
    v.features.add("Bike");
    v.features.add("Low Rider");
    
    System.out.println(v.features);
    
    Vehicle vClone = (Vehicle) v.clone();
    vClone.numWheels = 4;
    vClone.name = "Civic";
    vClone.color = "White";
    vClone.features.add("Comfort");
    vClone.features.add("Leather Seats");
    
    System.out.println(v.numWheels + " " + v.name + " " + v.color);
    System.out.println(vClone.numWheels + " " + vClone.name + " " + vClone.color);
    
    System.out.println(v.features);
    System.out.println(vClone.features);
    
    v.company.name = "Harley";
    vClone.company = new Company(); //If this is not initialized again then vClone.company will point to v.company
    vClone.company.name = "Honda";
    
    System.out.println(v.company.name);
    System.out.println(vClone.company.name);
  }
  
  static class Vehicle implements Cloneable {
    int numWheels = 0;
    String name, color;
    List<String> features = new ArrayList<String>();
    Company company = new Company();
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
      // TODO Auto-generated method stub
      return super.clone();
    }
  }
  
  static class Company {
    String name;
  }
}
