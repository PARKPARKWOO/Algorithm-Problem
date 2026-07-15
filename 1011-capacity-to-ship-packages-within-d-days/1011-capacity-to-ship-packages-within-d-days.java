class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0;
        int max = 0;
        int answer = Integer.MAX_VALUE;
        for (int w : weights) {
            min = Math.max(min, w);
            max += w;
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (can(weights, days, mid)) {
                answer = Math.min(answer, mid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return answer;
    }

    boolean can(int[] weight, int days, int k) {
        int day = 1;
        int capa = k;
        for (int w: weight) {
            if (capa >= w) {
                capa -= w;
            } else {
                capa = k;
                capa -= w;
                day++;
            }
        }

        return days >= day;
    }
}