class Solution {
    public int maximizeSum(int[] nums, int k) {
        int maxNum = 0;

        for (int n : nums) {
            maxNum = Math.max(maxNum, n);
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += maxNum + i;
        }

        return sum;
    }
}