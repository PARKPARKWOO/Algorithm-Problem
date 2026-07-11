class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] n = new int[20001];
        int answer = 0;
        int offset = 10000;
        for (int i : nums) {
            n[i + offset]++;
        }
        int idx = 0;
        for (int i = n.length - 1; i >= 0; i--) {
            idx += n[i];
            if (idx >= k) return i - offset;
        }

        return -1;
    }
}