class LRUCache {
    private Map<Integer, Node> cache;
    private int capa;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity) {
        this.capa = capacity;
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        this.head = head;
        this.tail = tail;
        head.next = tail;
        tail.pre = head;
        this.cache = new HashMap<>();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        removeAndInsert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            removeAndInsert(node);
            node.value = value;
            return;
        }
        if (this.capa <= cache.size()) {
            Node lru = head.next;
            remove(lru);
        }
        Node newNode = new Node(key, value);
        insert(newNode);
    }

    void removeAndInsert(Node node) {
        remove(node);
        insert(node);
    }

    void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        cache.remove(node.key);
    }

    void insert(Node node) {
        cache.put(node.key, node);
        tail.pre.next = node;
        node.pre = tail.pre;
        tail.pre = node;
        node.next = tail;
    }
}

class Node {
    int key;
    int value;
    Node pre;
    Node next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */