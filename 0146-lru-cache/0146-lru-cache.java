class LRUCache {
    int capa;
    Map<Integer, Data> map;
    Data head;
    Data tail;
    public LRUCache(int capacity) {
        this.capa = capacity;
        this.map = new HashMap<>();
        Data head = new Data(0, 0);
        Data tail = new Data(0, 0);
        this.head = head;
        this.tail = tail;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        Data value = map.get(key);
        if (value == null) return -1;
        remove(value);
        insert(value);
        return value.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Data v = map.get(key);
            v.value = value;
            remove(v);
            insert(v);
            return;
        }
        
        if (map.size() >= capa) {
            Data lru = head.next;
            head.next = lru.next;
            remove(lru);
        }
        Data newData = new Data(key, value);
        insert(newData);
    }

    void remove(Data data) {
        data.pre.next = data.next;
        data.next.pre = data.pre;
        
        map.remove(data.key);
    }

    void insert(Data data) {
        data.pre = tail.pre;
        data.next = tail;
        tail.pre.next = data;
        tail.pre = data;
        
        map.put(data.key, data);
    }
}

class Data {
    int key;
    int value;
    Data pre;
    Data next;
    public Data(int key, int value) {
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