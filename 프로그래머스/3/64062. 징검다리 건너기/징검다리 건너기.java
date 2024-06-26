class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 0;
        int max = Integer.MAX_VALUE;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (canJump(stones, mid, k)) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }
        return answer;
    }
    private boolean canJump(int[] stones, int mid, int k) {
        int cnt = 0;
        for (int i =0; i <stones.length; i++) {
            if (mid > stones[i]) {
                cnt++;
                if (cnt >= k) return false;
            } else {
                cnt = 0;
            }
        }
        return true;
    }
}