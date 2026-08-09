import java.util.*;
public class day44_BtreeTraversal {
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

    // Inorder: Left -> Root -> Right
    static void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    // Preorder: Root -> Left -> Right
    static void preorder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preorder(root.left);

        preorder(root.right);
    }

    // Postorder: Left -> Right -> Root
    static void postorder(Node root) {

        if (root == null) {
            return;
        }

        postorder(root.left);

        postorder(root.right);

        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes in the tree: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr);

        System.out.println("Inorder:");
        inorder(root);

        System.out.println();

        System.out.println("Preorder:");
        preorder(root);

        System.out.println();

        System.out.println("Postorder:");
        postorder(root);

        sc.close();
    }
}
