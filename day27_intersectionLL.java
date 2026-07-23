import java.util.Scanner;

public class day27_intersectionLL {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert at end
    static Node insert(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            return newNode;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    // Find length of linked list
    static int length(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    // Find intersection point
    static Node getIntersection(Node head1, Node head2) {

        int len1 = length(head1);
        int len2 = length(head2);

        Node p1 = head1;
        Node p2 = head2;

        int diff = Math.abs(len1 - len2);

        if (len1 > len2) {
            while (diff-- > 0) {
                p1 = p1.next;
            }
        } else {
            while (diff-- > 0) {
                p2 = p2.next;
            }
        }

        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // First linked list
        System.out.print("Enter the number of elements in the first linked list: ");
        int n = sc.nextInt();
        Node head1 = null;

        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            head1 = insert(head1, sc.nextInt());
        }

        // Second list input
        System.out.print("Enter the number of elements in the second linked list: ");
        int m = sc.nextInt();
        int[] arr = new int[m];

        System.out.print("Enter the elements: ");
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        Node head2 = null;
        Node tail2 = null;

        for (int i = 0; i < 2; i++) {
            Node newNode = new Node(arr[i]);

            if (head2 == null) {
                head2 = newNode;
                tail2 = newNode;
            } else {
                tail2.next = newNode;
                tail2 = newNode;
            }
        }

        Node temp = head1;
        while (temp != null && temp.data != arr[2]) {
            temp = temp.next;
        }

        // Connect second list to first list
        tail2.next = temp;

        // Find intersection
        Node ans = getIntersection(head1, head2);

        if (ans != null) {
            System.out.println(ans.data);
        } else {
            System.out.println("No Intersection");
        }

        sc.close();
    }
}