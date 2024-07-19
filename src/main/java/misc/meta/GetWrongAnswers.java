package misc.meta;

public class GetWrongAnswers {
    public static void main(String[] args) {
        // Write any import statements here

        System.out.println(getWrongAnswers(5, "AAAAA"));

    }

    public static String getWrongAnswers(int N, String C) {
        char[] result = new char[C.toCharArray().length];
        char[] actual = C.toCharArray();

        for (int i = 0; i < N; i++) {
            char temp = actual[i];
            char letter;
            if (temp == 'A') {
                letter = 'B';
            } else {
                letter = 'A';
            }
            result[i] = letter;
        }

        return String.valueOf(result);
    }
}
