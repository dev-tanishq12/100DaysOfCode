import java.util.Scanner;
import java.util.*;

public class day72_repeatedCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();  // Input string

        // Set to keep track of seen characters
        Set<Character> seen = new HashSet<>();

        // Iterate through the string
        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                System.out.println(c); // First repeated character
                return;
            }
            seen.add(c);
        }

        // If no repeated character found
        System.out.println(-1);
        sc.close();
    }
}
