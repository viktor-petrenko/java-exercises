package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ArrayDequeAndStackPerformanceComparison {
    // ArrayDeque is not sync
    // use ConcurrentLinkedDeque  if needed
    public static void main(String[] args) {
        /*
        In this  we are going to compare ArrayDeques and Stacks.
        Out aim is to implement a LIFO structure in the most efficient manner.
        So this is why we are going to measure the running time of the approaches.
        First let's consider ArrayDeques:
         */
        Deque<Integer> stack = new ArrayDeque<>();
        long now = System.currentTimeMillis();

        for (int i = 0; i < 500000; i++)
            stack.push(i);

        while (!stack.isEmpty()) stack.pop();

        System.out.println("Time taken with ArrayDeque: " + (System.currentTimeMillis() - now) + "ms");

        /*
         * In this example we insert 500.000 items into the data structure and then we keep popping (remove) all the items one by one.
         * Let's see the Stack data structure:
         */
        Stack<Integer> stack2 = new Stack<>();

        now = System.currentTimeMillis();

        for (int i = 0; i < 500000; i++)
            stack2.push(i);

        while (!stack2.isEmpty()) stack2.pop();

        System.out.println("Time taken with Stack: " + (System.currentTimeMillis() - now) + "ms");

       // CONCLUSION: because Stack is synchronized
        // (because it extends the Vector class)
        // this is why it is going to be slower than the ArrayDeque solution.
        // So it is advisable to use ArrayDeque if we are after a LIFO structure.
    }
}
