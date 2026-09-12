class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int answer = Integer.MAX_VALUE;
        int max = 0;
        int min = 1;
        for (int p : piles) {
            max = Math.max(p, max);
        }

        while (min <= max) {
            int k = min + (max - min) / 2;
            
            boolean can = can(piles, h, k);
            if (can) {
                max = k - 1;
                answer = Math.min(answer, k);
            } else {
                min = k + 1;
            }
        }
        return answer; 
    }

    boolean can(int[] piles, int h, int k) {
        long time = 0;
        
        for (int i = 0; i < piles.length; i++) {
            int p = piles[i];
            time += p / k;
            if (p % k != 0) time++;
        }

        return time <= h;
    }
}