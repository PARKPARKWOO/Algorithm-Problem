class Solution {
    int[] answer;
    public int[] topKFrequent(int[] nums, int k) {
        answer = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            if (idx >= k) break;
            int key = entry.getKey();
            int value = entry.getValue();
            answer[idx++] = key;
        }
        return answer;
    }
}