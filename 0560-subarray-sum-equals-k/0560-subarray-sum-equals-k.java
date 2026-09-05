class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int answer = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            sum += n;
            if (map.containsKey(sum - k)) {
                answer += map.get(sum -k);
                
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }
}