package misc.queue;

import java.util.*;

public class DequeExercises {
    // double ended queue (DEQUE)
    // Huge 1 dimensional arrays - O(10

    // FIFO
    public static void main(String[] args) {
        // FIFO
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(1);
        queue.offer(10);
        queue.offer(100);
        queue.offer(1000);

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

        // LIFO
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(1);
        stack.push(10);
        stack.push(100);
        stack.push(1000);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
