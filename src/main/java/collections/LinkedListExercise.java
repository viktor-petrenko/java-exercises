package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExercise {

    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<>();
        long startTimeArrayList = System.currentTimeMillis();

        for (int i = 0; i< 500000; ++i){
            arrayList.add(0, i);
        }

        System.out.println("Time taken for ArrayList: " + (System.currentTimeMillis() - startTimeArrayList));

        LinkedList<Integer> linkedList = new LinkedList<>();
        long startTimeLinkedList = System.currentTimeMillis();

        for (int i = 0; i< 500000; ++i){
            linkedList.addFirst(i);
        }

        System.out.println("Time taken for LinkedList: " + (System.currentTimeMillis() - startTimeLinkedList));



        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(10);

        LinkedList<Integer> linkedListFun = new LinkedList<>();

        linkedListFun.add(1);
        linkedListFun.addLast(1);
        linkedListFun.addFirst(10);

        linkedListFun.removeFirst();
        linkedListFun.removeFirst();

        System.out.println("isEmpty(): " + linkedListFun.isEmpty());
    }
}
