class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capa;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capa = capacity;
        Node head= new Node(0, 0);
        Node tail = new Node(0, 0);
        this.head = head;
        this.tail = tail;
        head.next = tail;
        tail.prev = head;
    }
    // head <-- prev, next --> tail (최근)
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node value = map.get(key);
        remove(value);
        insert(value);
        return value.value;
    }
    
    void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        
    }

    void insert(Node node){
        Node pre = tail.prev;
        tail.prev = node;
        node.next = tail;
        node.prev = pre;
        pre.next = node;
    }
    
    public void put(int key, int value) {
        // 있을때 -> 업데이트, 기존 값 삭제
        // 없을때 -> capa 초과시 lru 삭제 -> 삽입 
        if (!map.containsKey(key)) {
            if (capa <= map.size()) {
                Node lru = head.next;
                remove(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insert(newNode);
        } else {
            Node node = map.get(key);
            remove(node);
            insert(node);
            node.value = value;
        }
    }
}

class Node {
    int key;
    int value;
    Node prev;
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