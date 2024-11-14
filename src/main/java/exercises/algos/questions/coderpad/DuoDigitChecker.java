package exercises.algos.questions.coderpad;

import java.util.HashSet;
import java.util.Set;

public class DuoDigitChecker {
    public static String isDuoDigit(int number) {
        String numberStr = Integer.toString(Math.abs(number));  // Convert to string, take absolute value to ignore negative sign
        Set<Character> uniqueDigits = new HashSet<>();  // Use a Set to store unique digits

        for (char digit : numberStr.toCharArray()) {
            uniqueDigits.add(digit);
            if (uniqueDigits.size() > 2) {  // If more than two unique digits are found, return "n"
                return "n";
            }
        }

        return "y";  // If only two or fewer unique digits, return "y"
    }

    public static void main(String[] args) {
        System.out.println("1 -> " + isDuoDigit(1));         // Example output: y
        System.out.println("2020 -> " + isDuoDigit(2020));   // Example output: y
        System.out.println("-2021 -> " + isDuoDigit(-2021)); // Example output: n
    }
}
