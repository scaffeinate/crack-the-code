package chapter_3;

import java.io.FileNotFoundException;

import chapter_3.stack_queue.Animal;
import chapter_3.stack_queue.Cat;
import chapter_3.stack_queue.Dog;
import chapter_3.stack_queue.Shelter;
import util.InputUtil;

public class AnimalShelter {
  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents(3, "animal_shelter");
    Shelter<String> shelter = new Shelter<String>();
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];
      if (action.equals("enqueue")) {
        String type = values[1].split(":")[0];
        String name = values[1].split(":")[1];
        Animal<String> animal = null;
        if (type.equals("Dog")) {
          animal = new Dog<String>(name);
        } else if (type.equals("Cat")) {
          animal = new Cat<String>(name);
        }
        if (shelter.enqueue(animal)) {
          System.out.println("Enqueue " + animal.toString());
        }
      } else if (action.equals("dequeue")) {
        Animal<String> animal = shelter.dequeueAny();
        System.out.println("Dequeue Any => " + animal);
      } else if (action.equals("dequeueDog")) {
        Dog<String> dog = shelter.dequeueDog();
        System.out.println("Dequeue Dog => " + dog);
      } else if (action.equals("dequeueCat")) {
        Cat<String> cat = shelter.dequeueCat();
        System.out.println("Dequeue Cat => " + cat);
      }
    }
    
    System.out.println("Shelder holds: " + shelter.toString());
  }
}
