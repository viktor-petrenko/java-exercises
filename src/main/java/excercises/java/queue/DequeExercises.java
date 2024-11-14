package excercises.java.queue;

import java.util.*;

public class DequeExercises {
    // double ended queue (DEQUE)
    // Huge 1 dimensional arrays - O(10

    // FIFO
    public static void main(String[] args) {
        // FIFO
        Deque<Integer> queue = new ArrayDeque<>();
        //Inserts the specified element into the queue represented by this deque
        // (in other words, at the tail of this deque)
        queue.offer(1);
        queue.offer(10);
        queue.offer(100);
        queue.offer(1000);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
            // Retrieves and removes the head of the queue
        }

        // LIFO
        Deque<Integer> stack = new ArrayDeque<>();
        // Pushes an element onto the stack represented by this deque
        // (in other words, at the head of this deque)
        stack.push(1);
        stack.push(10);
        stack.push(100);
        stack.push(1000);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
            //  removes and returns the first element of this deque.
        }
    }
}
