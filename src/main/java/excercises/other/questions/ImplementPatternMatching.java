package excercises.other.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ImplementPatternMatching {
    /**
     * 1. Pattern matching using regular expressions
     *
     * Given a list of strings where N is the size of the input list, display the strings with the pattern matching the below constraints:
     *
     *     String length is also N
     *     String starts and ends with the same letter
     *
     * Note: If N = 4, the input will have 4 strings and the output should display strings with 4 letters that start and end with the same letter.
     * If N = 7, the input will have 7 strings and the output should display strings with 7 letters that start and end with the same letter.
     *
     * Example:
     *
     *     N = 4
     *         Input: 4, cddc, vadv, adsadasdf, lakedvl
     *         Output: cddc, vadv
     *
     *     N = 7
     *         Input: 7, gaabna, cadc, cakefn, cakeedcqw, abba, cadc, cakeasdasdfnc
     *         Output: cakeedc
     */
    public static void main(String[] args) {
        List<String> numbersList = Arrays.asList("cddc", "vadv", "adsadasdf", "lakedvl");
        System.out.println(matchPattern(numbersList));
    }

    public static List<String> matchPattern(List<String> a) {
        List<String> result = new ArrayList<>();

        for (String s : a) {
            if (s.length() == a.size() && s.charAt(0) == s.charAt(s.length() - 1)) {
                result.add(s);
            }
        }

        return result;
    }
}
