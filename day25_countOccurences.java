import java.util.Scanner;
public class day25_countOccurences{
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head, tail;

        void insert(int val) {
            Node node = new Node(val);
            if (head == null)
                head = tail = node;
            else {
                tail.next = node;
                tail = node;
            }
        }

        void display(Node head) {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    // Function to count occurrences of a given value in the linked list
    static int countOccurrences(Node head, int key) {
        int count = 0;
        Node current = head;
        while (current != null) {
            if (current.val == key)
                count++;
            current = current.next;
        }
        return count;
    }

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the linked list: ");
        int n = sc.nextInt();
        System.out.print("Enter the elements: ");
        LinkedList list = new LinkedList();

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            list.insert(val);
        }
        System.out.print("Enter the value to count occurrences for: ");
        int key = sc.nextInt();
        int occurrences = countOccurrences(list.head, key);
        System.out.println("Number of occurrences: " + occurrences);

        sc.close();
    }
}