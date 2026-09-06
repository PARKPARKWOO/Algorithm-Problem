class LRUCache {
    int capa;
    Map<Integer, Node> map;
    Node head;
    Node tail;
    // head (old) <-pre-next> tail(recent)
    public LRUCache(int capacity) {
        this.capa = capacity;
        this.map = new HashMap<>();
        Node head = new Node(0, 0 );
        Node tail = new Node(0, 0);
        this.head = head;
        this.tail = tail;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        moveToTail(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        // 새로운 node 가 추가될때 capa 를 초과한다면 예전 데이터를 삭제한다
        // insert / update 는 무조건 실행 한다.
        // tail 영역으로 이동되어야 한다.
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            remove(node);
        } else {
            if (map.size() >= this.capa) {
                Node lru = head.next;
                map.remove(lru.key);
                remove(lru);
            }
            node = new Node(key, value);    
            map.put(key, node);
        }
        moveToTail(node);
    }

    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToTail(Node node) {
        Node preNode = tail.pre;
        node.pre = preNode;
        preNode.next = node;
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
        this.value = value;
        this.key = key;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */