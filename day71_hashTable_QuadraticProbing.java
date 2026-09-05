import java.util.*;

public class day71_hashTable_QuadraticProbing{

    static int[] table;
    static int m;

    static void insert(int key) {

        int h = key % m;

        for (int i = 0; i < m; i++) {

            int index = (h + i * i) % m;

            if (table[index] == -1) {
                table[index] = key;
                return;
            }
        }
    }

    static boolean search(int key) {

        int h = key % m;

        for (int i = 0; i < m; i++) {

            int index = (h + i * i) % m;

            if (table[index] == -1) {
                return false;
            }

            if (table[index] == key) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Table size
        m = sc.nextInt();

        // Number of operations
        int n = sc.nextInt();

        table = new int[m];

        // -1 means empty
        Arrays.fill(table, -1);

        for (int i = 0; i < n; i++) {

            String operation = sc.next();

            int key = sc.nextInt();

            if (operation.equals("INSERT")) {
                insert(key);
            }

            else if (operation.equals("SEARCH")) {

                if (search(key)) {
                    System.out.println("FOUND");
                } else {
                    System.out.println("NOT FOUND");
                }
            }
        }

        sc.close();
    }
}