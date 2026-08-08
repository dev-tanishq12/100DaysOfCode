import java.util.*;

public class day43_Btree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Build tree from level order
    static Node buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        Node root = new Node(arr[0]);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (i < arr.length) {

            Node current = queue.poll();

            // Left child
            if (arr[i] != -1) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Inorder traversal
    static void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in level order: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements: ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr);

        inorder(root);

        sc.close();
    }
}