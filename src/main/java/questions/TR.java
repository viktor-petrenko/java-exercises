package questions;

public class TR {

    public static void main(String[] main) {
        int rows = 4; // Number of rows

        horizontalFullTreeToTheRight(rows);
        horizontalFullTreeToTheLeft(rows);
        leftSideUpsideDownTree(rows);
        rightTreeUpSideDown(rows);
        upsidedownTree(rows);
        fullsizeTree(rows);
        leftSideTree(rows);
        rightSideHalfTree(rows);
        // printRightSideHalfTreeStringBuilder();
    }

    private static void horizontalFullTreeToTheRight(int rows) {
        // Top half of the tree
        for (int i = 1; i <= rows; i++) {
            // Inner loop for stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line after each row
        }

        // Bottom half of the tree
        for (int i = rows - 1; i >= 1; i--) {
            // Inner loop for stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    /**
     * *
     * **
     * ***
     * **
     * *
     *
     * @param rows
     */

    private static void horizontalFullTreeToTheLeft(int rows) {
        // Top half of the tree (including the middle line)
        for (int i = 1; i <= rows; i++) {
            // Inner loop for spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Inner loop for stars
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line after each row
        }

        // Bottom half of the tree (excluding the middle line)
        for (int i = rows - 1; i >= 1; i--) {
            // Inner loop for spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Inner loop for stars
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line after each row
        }
    }


    /**
     * ***
     * **
     * *
     */
    private static void leftSideUpsideDownTree(int rows) {
        for (int i = rows; i >= 1; i--) { // Outer loop for the rows (reverse)
            // Inner loop for stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    /**
     * ***
     * **
     * *
     */
    private static void rightTreeUpSideDown(int rows) {
        for (int i = rows; i >= 1; i--) { // Outer loop for the rows (reverse)
            // Inner loop for spaces (left side)
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Inner loop for stars
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    /**
     * ******
     * ***
     * *
     */
    private static void upsidedownTree(int rows) {
        for (int i = rows; i >= 1; i--) { // Outer loop for the rows (reverse)
            // Inner loop for spaces (left side)
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Inner loop for stars (left side)
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            // Inner loop for stars (right side)
            for (int l = 1; l < i; l++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    /**
     * *
     * ***
     * *****
     */

    private static void fullsizeTree(int rows) {
        for (int i = 1; i <= rows; i++) { // Outer loop for the rows
            // Inner loop for spaces (left side)
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Inner loop for stars (left side)
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            // Inner loop for stars (right side)
            for (int l = 1; l < i; l++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    /**
     * *
     * **
     * ***
     */
    private static void leftSideTree(int rows) {

        for (int i = 1; i <= rows; i++) { // Outer loop for the rows
            // Inner loop for spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Inner loop for stars
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    /**
     * *
     * **
     * ***
     */

    private static void rightSideHalfTree(int rows) {
        for (int i = 1; i <= rows; i++) { // Outer loop for the rows
            for (int j = 1; j <= i; j++) { // Inner loop for the columns
                System.out.print("*"); // Print star
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    private static void printRightSideHalfTreeStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            System.out.println(stringBuilder.append("*"));

        }
    }


}
