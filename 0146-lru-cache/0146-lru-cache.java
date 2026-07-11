class LRUCache {
    int capa;
    Map<Integer, Node> map;
    // head = 제일 예전 데이터
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capa = capacity;
        this.map = new HashMap<>();
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        this.head = head;
        this.tail = tail;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        
        Node node = map.get(key);
        removeAndInsert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeAndInsert(node);
            node.value = value;
            return;
        }
        if (capa <= map.size()){
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
        map.remove(node.key);
    }

    void insert(Node node) {
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
        
        map.put(node.key, node);
    }
}
// pre 이전(예전) 데이터
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