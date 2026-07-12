class TimeMap {
    Map<String, List<Data>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Data> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Data(key, value, timestamp));
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        List<Data> list = map.get(key);
        if (list == null || list.isEmpty()) return "";
        
        int left = 0;
        int right = list.size() - 1;
        Data data = null;
        while (left <= right) {
            int mid = (left + right) / 2;
            Data d = list.get(mid);
            if (d.timestamp <= timestamp) {
                data = d;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (data == null) return "";
        return data.value;
    }
}

class Data {
    String key;
    String value;
    int timestamp;
    public Data(String key, String value, int timestamp) {
        this.key = key;
        this.value = value;
        this.timestamp = timestamp;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */