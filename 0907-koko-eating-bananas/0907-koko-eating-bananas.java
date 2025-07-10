class Solution {
    private int answer;
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long c = 0;
            for (int p : piles) {
                c += (p + mid - 1) / mid;
            }
            if (c <= h) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}