class TimeMap {
    Map<String, List<Node>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        List<Node> list = map.get(key);
        list.add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Node> list = map.get(key);
        if (list != null ) {
            int left = 0;
            int right = list.size() - 1;
            Node node = null;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                Node n = list.get(mid);
                if (n.time <= timestamp) {
                    node = n;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (node != null) return node.value;
        }
        return "";
    }
}

class Node {
    String value;
    int time;
    public Node(String value, int time) {
        this.value = value;
        this.time = time;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */