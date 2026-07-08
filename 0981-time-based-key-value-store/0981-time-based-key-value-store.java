class TimeMap {
    Map<String, List<Data>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Data> l = map.getOrDefault(key, new ArrayList<>());
        l.add(new Data(value, timestamp));
        map.put(key, l);
    }
    
    public String get(String key, int timestamp) {
        List<Data> list = map.get(key);
        if (list == null) return "";
        int end = list.size() -1;
        int start = 0;
        String answer = "";
        while (start <= end) {
            int mid = (start + end) / 2;
            Data d = list.get(mid);
            if (d.time <= timestamp) {
                answer = d.value;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }
}

class Data {
    String value;
    int time;
    public Data(String value, int time) {
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