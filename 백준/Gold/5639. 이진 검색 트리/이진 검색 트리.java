import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int rootValue = Integer.parseInt(br.readLine());
        Tree root = new Tree(rootValue);
        while ((line = br.readLine()) != null && line.length() > 0) {
            int value = Integer.parseInt(line.trim());
            insert(value, root);
        }
        postOrder(root);
    }

    private static void postOrder(Tree root) {
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        System.out.println(root.value);
    }

    private static void insert(int value, Tree parent) {
        if (parent.value > value) {
            if (parent.left != null) {
                insert(value, parent.left);
            } else {
                parent.left = new Tree(value);
            }
        } else {
            if (parent.right != null) {
                insert(value, parent.right);
            } else {
                parent.right = new Tree(value);
            }
        }
    }
}

class Tree {
    int value;
    Tree left;
    Tree right;
    Tree(int value) {
        this.value = value;
    }
}