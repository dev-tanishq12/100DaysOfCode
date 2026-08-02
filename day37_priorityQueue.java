import java.util.Scanner;

public class day37_priorityQueue {

    static int[] pq;
    static int size = 0;

    // Insert element
    static void insert(int value) {
        pq[size] = value;
        size++;
    }

    // Delete highest priority (smallest element)
    static void delete() {
        if (size == 0) {
            System.out.println(-1);
            return;
        }

        int minIndex = 0;

        for (int i = 1; i < size; i++) {
            if (pq[i] < pq[minIndex]) {
                minIndex = i;
            }
        }

        System.out.println(pq[minIndex]);

        // Shift elements left
        for (int i = minIndex; i < size - 1; i++) {
            pq[i] = pq[i + 1];
        }

        size--;
    }

    // Peek highest priority
    static void peek() {
        if (size == 0) {
            System.out.println(-1);
            return;
        }

        int min = pq[0];

        for (int i = 1; i < size; i++) {
            if (pq[i] < min) {
                min = pq[i];
            }
        }

        System.out.println(min);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of operations: ");
        int n = sc.nextInt();
        pq = new int[n];

        for (int i = 0; i < n; i++) {
            String op = sc.next();

            if (op.equals("insert")) {
                int x = sc.nextInt();
                insert(x);
            } else if (op.equals("delete")) {
                delete();
            } else if (op.equals("peek")) {
                peek();
            }
        }

        sc.close();
    }
}