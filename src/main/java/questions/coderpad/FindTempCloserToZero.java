package questions.coderpad;

class FindTempCloserToZero {
    public static int computeClosestToZero(int[] ts) {
        if (ts == null || ts.length == 0) {
            return 0;
        }

        int closest = ts[0];  // Initialize closest with the first element

        for (int temp : ts) {
            // Check if current temp is closer to zero than the closest found so far
            if (Math.abs(temp) < Math.abs(closest)) {
                closest = temp;
            } else if (Math.abs(temp) == Math.abs(closest)) {
                // If they are the same, prefer the positive one
                closest = Math.max(closest, temp);
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        int[] temperatures = {-10, -5, 3, 2, 5, -2};
        System.out.println(computeClosestToZero(temperatures));
    }
}