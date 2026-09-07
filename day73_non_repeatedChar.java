import java.util.*;

public class day73_non_repeatedChar{
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        // Array to store counts of each character
        int[] count = new int[26];

        // Count occurrences
        for (char c : s.toCharArray()) {
            count[c - 'a']++;   // increment count for this character
        }

        // Find first non-repeated
        for (char c : s.toCharArray()) {
            if (count[c - 'a'] == 1) {
                System.out.println(c);
                return;
            }
        }
        // If none found
        System.out.println(-1);
        sc.close();
    }
}
