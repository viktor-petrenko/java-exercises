package exercises.java.generics;

import java.util.*;

public class FinalHomework {


    public void runExercise() {
        Library<Algorithm> library = new Library<>();
        library.add(new SearchAlgorithm());
        library.add(new SortingAlgorithm());
        library.add(new GraphAlgorithm());

        Algorithm item = library.getLast();

        while (item != null) {
            item.execute();
            item = library.getLast();
        }
    }

    class SearchAlgorithm implements Algorithm {
        @Override
        public void execute() {
            System.out.println("SortingAlgorithm");
        }
    }

    class SortingAlgorithm implements Algorithm {
        @Override
        public void execute() {
            System.out.println("SortingAlgorithm");
        }
    }

    class GraphAlgorithm implements Algorithm {
        @Override
        public void execute() {
            System.out.println("GraphAlgorithm");
        }
    }

    static class Library<A extends Algorithm> {
        ArrayList<A> storage;

        public Library() {
            this.storage = new ArrayList<>();
        }

        public ArrayList<A> getStorage() {
            return storage;
        }

        public A getLast() {
            if (getStorage().size() <= 0) return null;

            A actualItem = getStorage().remove(getStorage().size() - 1);
            return actualItem;
        }

        public <T extends A> void add(T algo) {
            getStorage().add(algo);
        }
    }

     interface Algorithm {
        void execute();
    }
}
