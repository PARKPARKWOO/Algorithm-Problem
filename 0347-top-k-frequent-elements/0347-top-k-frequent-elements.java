class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int maxNum = 0;
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i : nums) {
            cache.put(i, cache.getOrDefault(i, 0) + 1);
        }
        List<Integer>[] graph = new List[nums.length + 1];
        int[] answer = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> e : cache.entrySet()) {
            int key = e.getKey();
            int value = e.getValue();
            
            if (graph[value] == null) {
                graph[value] = new ArrayList<>();
            }

            graph[value].add(key);
        }

        for (int i = graph.length -1; i >= 0 && idx < k; i--){ 
            List<Integer> list = graph[i];
            if (list == null) continue;

            for (int n : list) {
                if (idx >= k) break;
                answer[idx++] = n;
            }
        }
        
        return answer;
    }
}