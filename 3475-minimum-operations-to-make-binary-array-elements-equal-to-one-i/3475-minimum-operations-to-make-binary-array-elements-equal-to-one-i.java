class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] == 0) {
                flip(nums, i);
                result++;
            }
        }
        for (int x : nums) {
            if (x == 0) return -1;
        }
        return result;
    }

    private void flip(int[] nums, int idx) {
        for (int j = 0; j < 3; j++) {
            nums[idx + j] = nums[idx + j] ^ 1;
        }
    }
}
