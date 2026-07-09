class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxNum = 0;
        for (int p : piles) {
            maxNum = Math.max(maxNum, p);
        }
        int left = 1;
        int right = maxNum;
        int answer = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canFinish(piles, h, mid)) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    boolean canFinish(int[] piles, int h, int k) {
        long hour = 0;
        for (int i = 0; i < piles.length; i++) {
            int p = piles[i];
            hour += (p / k);
            if (p % k != 0) hour++;
        }

        return hour <= h;
    }
}