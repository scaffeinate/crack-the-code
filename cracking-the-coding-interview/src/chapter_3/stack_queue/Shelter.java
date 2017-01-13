package chapter_3.stack_queue;

import java.util.LinkedList;

public class Shelter<T> {
  LinkedList<Dog<T>> dogsList;
  LinkedList<Cat<T>> catsList;
  int order = 0;
  
  public Shelter() {
    dogsList = new LinkedList<Dog<T>>();
    catsList = new LinkedList<Cat<T>>(); 
  }
  
  public boolean enqueue(Animal<T> animal) {
    boolean added = false;
    if(animal == null) {
      return added;
    }
    animal.setOrder(this.order);
    if(animal.getClass().getSimpleName().equals("Dog")) {
      dogsList.add((Dog<T>) animal);
      added = true;
    } else if (animal.getClass().getSimpleName().equals("Cat")){
      catsList.add((Cat<T>) animal);
      added = true;
    }
    this.order++;
    return added;
  }
  
  public Animal<T> dequeueAny() {
    if(dogsList.isEmpty()) {
      return catsList.poll();
    } else if(catsList.isEmpty()) {
      return dogsList.poll();
    }
    
    Dog<T> dog = dogsList.peek();
    Cat<T> cat = catsList.peek();
    
    if(dog.isOlderThan(cat)) {
      return dequeueDog();
    } else {
      return dequeueCat();
    }
  }

  public Dog<T> dequeueDog() {
    return dogsList.poll();
  }
  
  public Cat<T> dequeueCat() {
    return catsList.poll();
  }
}
