class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Map<Integer, Integer> cache = new HashMap<>();
    
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int value = cache.getOrDefault(target - num, Integer.MAX_VALUE);
            if (value == Integer.MAX_VALUE) {
                cache.put(num, i);
            } else {
                answer[0] = value;
                answer[1] = i;
                break;
            }        
        }
        
        return answer;
    }
}