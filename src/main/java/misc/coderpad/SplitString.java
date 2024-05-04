package misc.coderpad;

public class SplitString {

    /**
     In this code:

     str is the string to be split.
     split("\\n") is used to divide the string into parts wherever a newline (\n) occurs.
     The double backslash (\\) is used in the delimiter because in Java, backslashes in strings must be escaped.

     This results in lines being an array of strings, where each element is a line from the original string.
    */

    public static void main(String[] args) {
        String str = "This is a string\nThis is the next line.\nHello world.";
        String[] lines = str.split("\\n");

        for(String line : lines){
            System.out.println(line);
        }

    }
}
