package questions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithTwoDistinctChars {

    public static int getDistinctChar(String text) {
        int maxLength = 0;
        int left = 0;

        Map<Character, Integer> charMap = new HashMap<>();

        for (int right = 0; right < text.length(); right++) {
            char charRight = text.charAt(right);
            charMap.put(charRight, charMap.getOrDefault(charRight, 0) + 1);

            while (charMap.size() > 2) {
                char charLeft = text.charAt(left);
                charMap.put(charLeft, charMap.get(charLeft) - 1);
                if (charMap.get(charLeft) == 0) {
                    charMap.remove(charLeft);
                }
                left++;
            }
            System.out.println("maxLength: " + maxLength + " - right: " + right + " left: " + left + " +1 = "+ maxLength);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(getDistinctChar("eceba")); // Output: 3
        System.out.println(getDistinctChar("ccaabbb")); // Output: 5
    }
}
