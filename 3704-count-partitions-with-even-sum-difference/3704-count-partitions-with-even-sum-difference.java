class Solution {
    public int countPartitions(int[] nums) {
        int answer = 0;
        int sum = Arrays.stream(nums).sum();
        boolean right = (sum % 2 ==0);
        boolean left = true;
        for (int i = 0; i< nums.length;i++) {
            int n = nums[i];
            if (n % 2 != 0) {
                right = !right;
                left = !left;
            }
            if (i < nums.length - 1 && left == right) {
                answer++;
            }
        }
        return answer;
    }
}