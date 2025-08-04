class Solution {
    private Map<Integer, Integer> counter = new HashMap<>();
    private Map<Integer, Integer> nums = new HashMap<>();
    public long maximumImportance(int n, int[][] roads) {
        long answer = 0;
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
        
        for (int[] r: roads) {
            int a = r[0];
            int b = r[1];
            answer += (nums.get(a) + nums.get(b));
        }
        return answer;
    }
}