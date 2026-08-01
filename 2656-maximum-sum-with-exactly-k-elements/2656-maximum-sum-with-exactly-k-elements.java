class Solution {
    public int maximizeSum(int[] nums, int k) {
        int maxNum = 0;

        for (int n : nums) {
            maxNum = Math.max(maxNum, n);
        }

        return k * maxNum + k * (k - 1)  / 2;
    }
}