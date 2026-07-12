class Solution {
    int answer = Integer.MAX_VALUE;
    int min = 1;
    int max;
    public int minEatingSpeed(int[] piles, int h) {
        max = 0;
        for (int i : piles) {
            max = Math.max(i, max);
        }
        
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (can(piles, mid, h)) {
                max = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                min = mid + 1;
            }
        }
        
        return answer;
    }

    boolean can(int[] piles, int k, int h) {
        long hour = 0;
        
        for (int p : piles) {
            hour += p / k;
            if (p % k != 0) hour++;
        }
        return h >= hour;
    }
}