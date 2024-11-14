package excercises.algos.questions;

public class Palendrom {

    public static void main(String[] args) {
        String text = "Toyota racecar is on level one, Honda civic is on level seven";
        reverseEachWordInTheString(text);
        gatherOnlyPalendromes(text);
    }

    private static void gatherOnlyPalendromes(String text) {
        StringBuilder sb = new StringBuilder();
        for (String word : text.split(" ")) {
            if (isPalendrome(word)) {
                sb.append(word);
            }
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

    private static boolean isPalendrome(String word) {
        int mid = word.length() / 2;
        String[] parts = new String[0];

        if (word.length() % 2 == 0) {
            parts = new String[]{word.substring(0, mid), word.substring(mid)};

        } else if (word.length() % 2 != 0) {
            parts = new String[]{word.substring(0, mid), word.substring(mid + 1)};
        }

        StringBuilder reversedSecondPart = new StringBuilder();
        for (int i = parts[1].length(); i > 0; i--) {
            reversedSecondPart.append(parts[1].charAt(i - 1));
        }
        return reversedSecondPart.toString().equals(parts[0]);
    }

    private static void reverseEachWordInTheString(String text) {
        StringBuilder sb = new StringBuilder();
        for (String word : text.split(" ")) {
            for (int i = word.length(); i > 0; i--) {
                sb.append(word.charAt(i - 1));
            }
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
