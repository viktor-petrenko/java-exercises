package leetcode;

public class FindTheIndexOfTheFirstOccurrenceInString28 {

    public static void main(String[] args) {
        findNeedleIndex("hello", "ll");
        findNeedleIndex1("hello", "ll");
        findNeedleIndex3("hello", "ll");
    }

    public static int findNeedleIndex(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) && i + needle.length() <= haystack.length()) {
                if (haystack.substring(i, i + needle.length()).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int findNeedleIndex1(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) && i + needle.length() <= haystack.length()) {
                if (haystack.startsWith(needle, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int findNeedleIndex3(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        if (needleLength > haystackLength) {
            return -1;
        }

        for (int i = 0; i <= haystackLength - needleLength; i++) {
            int j = 0;

            /**
             * Keep comparing characters while:
             * 1. j is still inside needle
             * 2. current haystack character equals current needle character
             */
            while (j < needleLength && haystack.charAt(i + j) == needle.charAt(j)) {
               // j < needleLength do not go outside needle
                j++;
            }

            if (j == needleLength) {
                return i;
            }
        }

        return -1;
    }
}