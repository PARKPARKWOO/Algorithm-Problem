class Solution {
    int answer = Integer.MAX_VALUE;
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;
        for (int p : piles) {
            max = Math.max(p , max);
        }
        
        while (min <= max) {
            int mid = min + (max - min) / 2;
            boolean can = recur(piles, h, mid);
            if (can) {
                max = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                min = mid + 1;
            }
        }
        
        return answer;
    }

    boolean recur(int[] piles, int h,int k) {
        long time = 0;
        for (int i = 0; i < piles.length; i++) {
            int p = piles[i];
            time += p / k;
            if (p % k != 0) time++;
        }
        return time <= h;
    }
}