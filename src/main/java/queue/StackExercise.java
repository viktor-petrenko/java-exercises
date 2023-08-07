package queue;

import java.util.Stack;

public class StackExercise {

    /**
     * We have considered Vectors - and we came to the conclusion that ArrayList is a better option usually.
     *
     * Stack extends the Vector class - which means that stacks are inherently synchronized.
     *
     * however synchronization is not always needed - in such cases it is better to use ArrayDeque
     * @param args
     */
    public static void main(String[] args){
        Stack<String> names = new Stack<>();

        names.push("Adam");
        names.push("Joe");
        names.push("Ana");
        names.push("Daniel");
        names.push("katy");

        System.out.println(names.size());
        System.out.println(names.pop());
        System.out.println(names.size());

        while(!names.isEmpty()){
            System.out.printf(names.pop());
        }


    }
}
