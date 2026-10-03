import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // Step 1: Pair cars (position, speed)
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Step 2: Sort by position descending
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        // Step 3: Iterate and count fleets
        int fleets = 0;
        double lastTime = -1.0;

        for (int i = 0; i < n; i++) {
            double time = (target - cars[i][0]) / cars[i][1];
            if (time > lastTime) {
                fleets++;
                lastTime = time; // new fleet leader
            }
            // else: car joins existing fleet
        }

        return fleets;
    }

    // Example run
    public static void main(String[] args) {
        Solution sol = new Solution();
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println(sol.carFleet(target, position, speed)); 
        // Output: 3
    }
}
