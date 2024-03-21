import java.util.*;
class Solution {
    int gcd;
    public long solution(int n, int[] times) {
        long answer = 0;
        if (times.length == 1) {
            return times[0] * n;
        }
        Arrays.sort(times);
        long left = 0;
        long right = times[times.length -1] * (long) n;
        while (left <= right) {
            long mid = (left + right) / 2;
            long complete = 0;
            for (int i = 0; i < times.length; i++) {
                complete += mid / times[i];
            }
            if (complete < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
    
}