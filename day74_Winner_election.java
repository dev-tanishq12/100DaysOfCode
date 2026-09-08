import java.util.*;

public class day74_Winner_election {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, Integer> map = new HashMap<>();

        // Count votes
        for (int i = 0; i < n; i++) {

            String name = sc.next();

            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        String winner = "";
        int maxVotes = 0;

        // Find winner
        for (String name : map.keySet()) {

            int votes = map.get(name);

            if (votes > maxVotes) {

                maxVotes = votes;
                winner = name;

            } else if (votes == maxVotes &&
                       name.compareTo(winner) < 0) {

                winner = name;
            }
        }

        System.out.println(winner + " " + maxVotes);

        sc.close();
    }
}