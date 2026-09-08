class TimeMap {
    Map<String, List<Node>> map = new HashMap<>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        Node node = new Node(value, timestamp);
        List<Node> list = this.map.get(key);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(node);
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        List<Node> list = map.get(key);
        if (list != null) {
            int right = list.size() - 1;
            int left = 0;
            String answer = "";
            while (left <= right) {
                int mid = left + (right - left) / 2;
                Node get = list.get(mid);
                if (get.time <= timestamp) {
                    left = mid + 1;
                    answer = get.value;
                } else {
                    right = mid - 1;
                }
            }
            return answer;
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