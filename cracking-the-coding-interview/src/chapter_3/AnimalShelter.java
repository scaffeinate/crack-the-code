package chapter_3;

import java.io.FileNotFoundException;

import chapter_3.stack_queue.Animal;
import chapter_3.stack_queue.Cat;
import chapter_3.stack_queue.Dog;
import chapter_3.stack_queue.Shelter;
import util.InputUtil;

/**
 * Question 3.6: An animal shelter, which holds only dogs and cats, operates
 * strictly "first" in, first out" basis. People must adopt either the
 * "oldest"(based on arrival time) of all animals at the shelter or they can
 * select whether they would prefer a dog or a cat(and will receive the oldest
 * animal of that type). They cannot select which specific animal they would
 * like. Create the data structures to maintain this system and implement
 * operations such as enqueue, dequeueAny, dequeueDog and dequeueCat. You may
 * use the built-in LinkedList data structure.
 * 
 * @author Sudharsanan Muralidharan
 *
 */
public class AnimalShelter {
  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents(3, "animal_shelter");
    Shelter<String> shelter = new Shelter<String>();
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];
      Animal<String> animal = null;
      switch (action) {
      case "enqueue":
        String type = values[1].split(":")[0];
        String name = values[1].split(":")[1];
        if (type.equals("Dog")) {
          animal = new Dog<String>(name);
        } else if (type.equals("Cat")) {
          animal = new Cat<String>(name);
        }
        if (shelter.enqueue(animal)) {
          System.out.println("Enqueue " + animal.toString());
        }
        break;
      case "dequeue":
        animal = shelter.dequeueAny();
        System.out.println("Dequeue Any => " + animal);
        break;
      case "dequeueDog":
        Dog<String> dog = shelter.dequeueDog();
        System.out.println("Dequeue Dog => " + dog);
        break;
      case "dequeueCat":
        Cat<String> cat = shelter.dequeueCat();
        System.out.println("Dequeue Cat => " + cat);
        break;
      }
    }

    System.out.println("Shelder holds: " + shelter.toString());
  }
}
