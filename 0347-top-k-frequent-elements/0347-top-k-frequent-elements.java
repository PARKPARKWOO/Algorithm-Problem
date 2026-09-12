class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[k];
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        int idx = 0;
        for (int i = list.size() - 1; i > list.size() - k - 1; i--) {
            Map.Entry<Integer, Integer> entry = list.get(i);
            answer[idx++] = entry.getKey(); 
        }

        return answer;
    }
}