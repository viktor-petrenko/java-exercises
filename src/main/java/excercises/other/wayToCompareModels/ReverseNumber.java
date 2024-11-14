package excercises.other.wayToCompareModels;

public class ReverseNumber {
    static int rev = 0;

    static void reverse(int n) {
        if (n <= 0) return;
        int rem = n % 10; // Extracting the Last Digit
        rev = (rev * 10) + rem; // Building the Reversed Number
        reverse(n / 10);
    }

    public static void main(String[] args) {
        int n = 4526;
        reverse(n);
        System.out.print("Reversed Number is " + rev);
    }
}
