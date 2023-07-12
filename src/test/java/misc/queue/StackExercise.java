package misc.queue;

import java.util.Stack;

public class StackExercise {
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
