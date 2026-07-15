class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> answer = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        PriorityQueue<Data> pq = new PriorityQueue<>();
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int cnt = entry.getValue();
            
            pq.add(new Data(key, cnt));
        }

        for (int i = 0; i < k; i++) {
            Data d = pq.poll();
            answer.add(d.key);
        }
        
        return answer;
    }
}

class Data implements Comparable<Data>{
    String key;
    int cnt;
    public Data(String key, int cnt) {
        this.key = key;
        this.cnt = cnt;
    }

    public int compareTo(Data o) {
        if (this.cnt == o.cnt) {
            return this.key.compareTo(o.key);
        }

        return o.cnt - this.cnt;
    }
}