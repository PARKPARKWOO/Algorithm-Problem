class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int total = 0;
        map.put(0 ,1);
        for (int n : nums) {
            total += n;
            if (map.containsKey(total -k)) {
                answer += map.get(total - k);
            }

            map.put(total, map.getOrDefault(total, 0) + 1);
        }

        return answer;
    }
}