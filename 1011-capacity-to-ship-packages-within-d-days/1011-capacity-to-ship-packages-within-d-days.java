class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int min = 1;
        int answer = Integer.MAX_VALUE;
        for (int w : weights) {
            max += w;
            min = Math.max(w, min);
        }
        
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int d = can(weights, days, mid);
            if (d <= days) {
                max = mid - 1;
                answer = Math.min(answer, mid); 
            } else {
                min = mid + 1;
            } 
        }
        return answer;
    }

    int can(int[] weights, int days, int k) {
        int d = 1;
        int amount = k;
        for (int i = 0; i < weights.length; i++) {
            int w = weights[i];
            if (w <= amount) {
                amount -= w;
            } else {
                amount = k;
                amount -= w;
                d++;
            }
        }

        return d;
    }
}