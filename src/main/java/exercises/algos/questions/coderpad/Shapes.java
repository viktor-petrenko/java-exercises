package exercises.algos.questions.coderpad;

public class Shapes {

    /**
     * the Shape class is an abstract class that has an int attribute surface.
     * This attribute is set by calling the computeSurface() method in the constructor of Shape.
     * The computeSurface() method is abstract, meaning it must be implemented by any class that extends Shape.
     * The SquareShape class extends Shape and implements the computeSurface() method, which calculates the surface area as the square of its size attribute.
     * Here's the crucial part to consider: when the SquareShape constructor is invoked, it first calls the constructor of its superclass,
     * Shape, which itself calls the computeSurface() method. However, at this time,
     * the size attribute of SquareShape has not yet been initialized (it is initialized after the superclass's constructor completes).
     * In Java, uninitialized int variables default to 0.
     * As a result, when computeSurface() is called during the construction process of SquareShape, the size attribute is still 0,
     * leading computeSurface() to return 0 * 0, which is 0. Therefore, the surface attribute of Shape is set to 0.
     * Thus, when you call getSurface() on a SquareShape object (squareShape.getSurface()), it returns the value of the surface attribute,
     * which is 0. The expected behavior of the code to return 100 (the square of 10) does not happen because
     * of the order in which constructors and initialization blocks are executed in Java.
     * Therefore, the value of the variable mySurface will be 0.
     *
     * @param args
     */

    public static void main(String[] args) {
        SquareShape squareShape = new SquareShape(10);
        int mySurface = squareShape.getSurface();
    }

    public static abstract class Shape {
        private int surface;

        public Shape() {
            this.surface = computeSurface();
        }

        protected abstract int computeSurface();

        public int getSurface() {
            return surface;
        }
    }

    public static class SquareShape extends Shape {
        private final int size;

        public SquareShape(int size) {
            this.size = size;
        }

        @Override
        protected int computeSurface() {
            return size * size;
        }
    }

}
