class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        int idx = 0;
        for (int i = entryList.size() - 1; i >= entryList.size() - k; i--) {
            answer[idx++] = entryList.get(i).getKey();
        }
        return answer;
    }
}