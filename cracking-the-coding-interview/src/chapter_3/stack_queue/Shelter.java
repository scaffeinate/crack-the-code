package chapter_3.stack_queue;

import java.util.LinkedList;

/**
 * class Shelter
 * <p>
 * Book solution implemented
 *
 * @param <T>
 * @author Sudharsanan Muralidharan
 */
public class Shelter<T> {
    LinkedList<Dog<T>> dogsList;
    LinkedList<Cat<T>> catsList;
    int order = 0, size = 0;

    /**
     * Have two LinkedLists one for Dog and one for Cat
     */
    public Shelter() {
        dogsList = new LinkedList<Dog<T>>();
        catsList = new LinkedList<Cat<T>>();
    }

    /**
     * Set order add to appropriate LinkedList
     *
     * @param animal
     * @return added
     */
    public boolean enqueue(Animal<T> animal) {
        boolean added = false;
        if (animal == null) {
            return added;
        }
        animal.setOrder(this.order);
        if (animal.getClass().getSimpleName().equals("Dog")) {
            dogsList.add((Dog<T>) animal);
            added = true;
        } else if (animal.getClass().getSimpleName().equals("Cat")) {
            catsList.add((Cat<T>) animal);
            added = true;
        }
        this.order++;
        this.size++;
        return added;
    }

    /**
     * Dequeue either Dog or Cat based on order
     *
     * @return animal
     */
    public Animal<T> dequeueAny() {
        if (dogsList.isEmpty()) {
            this.size--;
            return catsList.poll();
        } else if (catsList.isEmpty()) {
            this.size--;
            return dogsList.poll();
        }

        Dog<T> dog = dogsList.peek();
        Cat<T> cat = catsList.peek();

        if (dog.isOlderThan(cat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    /**
     * Dequeue from dogList
     *
     * @return dog
     */
    public Dog<T> dequeueDog() {
        this.size--;
        return dogsList.poll();
    }

    /**
     * Dequeue from catList
     *
     * @return cat
     */
    public Cat<T> dequeueCat() {
        this.size--;
        return catsList.poll();
    }

    /*
     * @Override toString
     *
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Animal<T> animal;
        while ((animal = dequeueAny()) != null) {
            builder.append(animal.getName()).append(":").append(animal.getOrder()).append(", ");
        }

        builder.replace(builder.length() - 2, builder.length(), "]");

        return builder.toString();
    }
}
