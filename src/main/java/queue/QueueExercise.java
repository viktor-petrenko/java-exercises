package queue;

import questions.Person;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExercise {

    /**
     * We insert items in the end of the queue and items are removed from the beginning of the queue
     * <p>
     * FIFO STRUCTURE -> FIRST IN FIRST OUT
     * <p>
     * WE insert items here + get items here <--> | Stack
     * WE insert items here -> | QUEUE | -> we get the items here
     * <p>
     * java.utl.LinkedList
     * java.util.PriorityQueue -> PriorityQueue stores its elements internally according to their natural order
     * (if they implement comparable)
     * <p>
     * add() -> we add items to our queue
     * <p>
     * element() -> approximetely the same as peel(); we git first without removing it
     * remove() -> this method removes the element at the head of the queue
     *
     * @param args
     */
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Adam");
        queue.add("Joe");
        queue.add("Ana");
        queue.add("Daniel");
        queue.add("katy");
        queue.offer("katy2");

        System.out.println("Remove item: " + queue.remove());
        System.out.println("Check 1 item: " + queue.element());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

        Queue<Person> personsQueue = new PriorityQueue<>();
        personsQueue.add(new Person("Kevin", 11));
        personsQueue.add(new Person("Agga", 55));
        personsQueue.add(new Person("Anna", 22));

        while (!personsQueue.isEmpty()) {
            System.out.println(personsQueue.poll());
        }
    }
}
