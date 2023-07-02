package misc;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExercise {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Adam");
        queue.add("Joe");
        queue.add("Ana");
        queue.add("Daniel");
        queue.add("katy");

        for (String s : queue) {
            System.out.println(s);
        }
    }
}
