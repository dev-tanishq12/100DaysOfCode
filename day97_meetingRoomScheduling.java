import java.util.*;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Min-heap for end times
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // Step 3: Process meetings
        for (int[] interval : intervals) {
            // If the room is free (current start >= earliest end), reuse it
            if (!heap.isEmpty() && interval[0] >= heap.peek()) {
                heap.poll();
            }
            // Allocate room (push current end time)
            heap.offer(interval[1]);
        }

        // Step 4: Heap size = number of rooms required
        return heap.size();
    }

    // Example run
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals1 = {{0,30},{5,10},{15,20}};
        System.out.println(sol.minMeetingRooms(intervals1)); // Output: 2

        int[][] intervals2 = {{7,10},{2,4}};
        System.out.println(sol.minMeetingRooms(intervals2)); // Output: 1
    }
}
