class TimeMap {
    Map<String, List<Data>> map;
    public TimeMap() {
        this.map = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        Data data = new Data(value, timestamp);
        
        List<Data> list = map.get(key);
        if (list == null) list = new ArrayList<>();
        list.add(data);
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        // "" 이 반환되는 케이스 = 1. 키 값이 없음 2. 데이터는 있지만 시간이 지났음
        String result = "";
        if (map.containsKey(key)) {
            List<Data> list = map.get(key);
            int left = 0;
            int right = list.size() - 1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                Data data = list.get(mid);
                if (data.time <= timestamp) {
                    left = mid + 1;
                    result = data.value;
                } else {
                    right = mid - 1;
                }
            }
        }

        return result;
    }
}
class Data {
    String value;
    int time;
    public Data(String value, int time){
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