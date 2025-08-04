class Solution {
    private Map<Integer, Integer> counter;
    private Map<Integer, Integer> nums;
    public long maximumImportance(int n, int[][] roads) {
        long answer = 0;
        counter = new HashMap<>();
        nums = new HashMap<>();
        for (int[] r: roads) {
            int a = r[0];
            int b = r[1];
            counter.put(a, counter.getOrDefault(a, 0) + 1);
            counter.put(b, counter.getOrDefault(b, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(counter.entrySet());
        entries.sort(
            Map.Entry.<Integer, Integer>comparingByValue()
             .reversed()
        );
        int cnt = n;
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            nums.put(key, cnt--);
        }
        
for (int[] road : roads) {
    int a = road[0];
    int b = road[1];
    answer += nums.getOrDefault(a, 0) + nums.getOrDefault(b, 0);
}
        return answer;
    }
}