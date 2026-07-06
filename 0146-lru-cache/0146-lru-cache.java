class LRUCache {
    private Map<Integer, Node> cache;
    private int capa;
    private Node head;
    private Node tail;
    public LRUCache(int capacity) {
        this.capa = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = tail;
        this.tail.pre = head;
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
        } else if (capa <= cache.size()){
            Node lru = head.next;
            cache.remove(lru.key);
            remove(lru);
        }
        Node newNode = new Node(key, value);
        insert(newNode);
        cache.put(key, newNode);
    }

    void removeAndInsert(Node node) {
        remove(node);
        insert(node);
    }

    void insert(Node node) {
        Node pre = tail.pre;
        node.pre = pre;
        pre.next = node;
        tail.pre = node;
        node.next = tail;
    } 

    void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}

class Node {
    int key;
    int value;
    Node pre;
    Node next;
    public Node(int key, int value ) {
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