import java.util.*;

public class Main {
    static int K;
    static Node root;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            String r = sc.next();
            String l = sc.next();
            String rr = sc.next();
            createNode(r, l, rr);
        }
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }
    static class Node{
        String data;
        Node left;
        Node right;

        public Node(String data) {
            this.data = data;
        }
    }
    static void createNode(String data, String leftData, String rightData) {
        if (root == null) {
            root = new Node(data);
            if (!leftData.equals(".")) root.left = new Node(leftData);

            if (!rightData.equals(".")) root.right = new Node(rightData);

        } else {
            searchNode(root, data, leftData, rightData);
        }
    }

    private static void searchNode(Node node, String data, String leftData, String rightData) {
        if (node == null) return;
        else if (node.data.equals(data)) {
            if (!leftData.equals(".")) node.left = new Node(leftData);
            if (!rightData.equals(".")) node.right = new Node(rightData);
        }
        else {
            searchNode(node.left, data, leftData, rightData);
            searchNode(node.right, data, leftData, rightData);
        }
    }

    //중위 순회
    static void inOrder(Node node) {
        if (node != null) {
            if (node.left != null) inOrder(node.left);
            System.out.print(node.data);
            if (node.right != null) inOrder(node.right);
        }
    }

    //전위 순회
    static void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data);
            if (node.left != null) preOrder(node.left);
            if (node.right != null) preOrder(node.right);
        }
    }

    //후위 순회
    static void postOrder(Node node) {
        if (node != null) {
            if (node.left != null) postOrder(node.left);
            if (node.right != null) postOrder(node.right);
            System.out.print(node.data);
        }
    }

}
