class Solution {
    public int[] rearrangeArray(int[] nums) {
        int p = 0;
        int m = 1;
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n < 0) {
                answer[m] = n;
                m += 2;
            } else {
                answer[p] = n;
                p += 2;
            }
        }
        return answer;
    }
}