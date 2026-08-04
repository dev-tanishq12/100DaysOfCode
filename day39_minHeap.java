import java.util.*;

public class day39_minHeap {

    static ArrayList<Integer> heap = new ArrayList<>();

    // Insert into heap
    static void insert(int value) {
        heap.add(value);

        int i = heap.size() - 1;

        while (i > 0) {
            int parent = (i - 1) / 2;

            if (heap.get(parent) > heap.get(i)) {
                int temp = heap.get(parent);
                heap.set(parent, heap.get(i));
                heap.set(i, temp);

                i = parent;
            } else {
                break;
            }
        }
    }

    // Peek minimum element
    static void peek() {
        if (heap.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(heap.get(0));
        }
    }

    // Extract minimum element
    static void extractMin() {
        if (heap.isEmpty()) {
            System.out.println(-1);
            return;
        }

        System.out.println(heap.get(0));

        int last = heap.get(heap.size() - 1);
        heap.set(0, last);
        heap.remove(heap.size() - 1);

        int i = 0;

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }

            if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest != i) {
                int temp = heap.get(i);
                heap.set(i, heap.get(smallest));
                heap.set(smallest, temp);

                i = smallest;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of operations:");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String op = sc.next();

            if (op.equals("insert")) {
                int value = sc.nextInt();
                insert(value);
            } 
            else if (op.equals("peek")) {
                peek();
            } 
            else if (op.equals("extractMin")) {
                extractMin();
            }
        }

        sc.close();
    }
}