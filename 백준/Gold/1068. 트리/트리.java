import java.util.*;

public class Main {
    static int N, removeIdx, cnt;
    static Node root;
    static List<Node> nodes = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int data = 0; data < N; data++) {
            int parent = sc.nextInt();
            create(data, parent);
        }
        removeIdx = sc.nextInt();
        search();
        real();
        removeNode(root);
        if (removeIdx == root.data) System.out.println(0);
        else {
            counting(root);
            System.out.println(cnt);
        }
    }

    static void real() {
        for (Node node : nodes) {
            if (node.parent == -1 && node.ch.size() != 0) {
                root = node;
            }
        }
    }
    static void create(int data, int parent){
        Node node = new Node(data, parent);
        nodes.add(node);
    }
    static void removeNode(Node node) {
        if (node.ch.size() == 0) return;
        Node remove = null;
        for (Node ch : node.ch) {
            if (ch.data == removeIdx) remove = ch;
            else removeNode(ch);
        }
        if (remove != null) node.ch.remove(remove);
    }

    static void counting(Node node) {
        if (node.ch.size() == 0) cnt++;
        else for (Node ch : node.ch) counting(ch);
    }

    static void search() {
        for (Node node : nodes) {
            for (Node node1 : nodes) {
                if (node.parent == -1) {
                    root = node;
                    break;
                }
                else if (node.parent == node1.data) node1.ch.add(node);
            }
        }
    }
    static class Node{
        int data;
        int parent;
        List<Node> ch;
        public Node(int data, int parent) {
            this.data = data;
            this.parent = parent;
            this.ch = new ArrayList<>();
        }
    }
}
