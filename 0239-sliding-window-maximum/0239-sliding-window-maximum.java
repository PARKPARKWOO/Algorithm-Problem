class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer = new int[nums.length - k + 1];
        int maxNum = Integer.MIN_VALUE;
        int left = 0;
        int idx = 0;
        // 0:index 1: value 값 기반
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (int right = 0; right < nums.length; right++) {
            pq.add(new int[]{right, nums[right]});
            
            if (right - left + 1 >= k) {
                while (!pq.isEmpty() && pq.peek()[0] < left) {
                    pq.poll();
                }
                left++;
                answer[idx++] = pq.peek()[1];
            }
        }
        return answer;
    }
}