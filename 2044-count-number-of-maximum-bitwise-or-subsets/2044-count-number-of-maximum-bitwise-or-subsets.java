class Solution {
    private int maxBitNum;
    private int answer;
    public int countMaxOrSubsets(int[] nums) {
        for (int n: nums) {
            maxBitNum |= n;
        }
        recursive(nums, 0, 0, 0);
        return answer;
    }
    
    private void recursive(int[] nums, int idx, int bit, int cnt) {
        if (idx >= nums.length) {
            if (maxBitNum == bit) {
                answer++;
            }
            return;
        }
        recursive(nums, idx + 1, bit, cnt);
        int curBit = nums[idx] | bit;
        recursive(nums, idx + 1, curBit, cnt + 1);
    }
}