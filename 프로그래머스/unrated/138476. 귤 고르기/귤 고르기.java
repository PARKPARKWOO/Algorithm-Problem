import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int maxValue = 0;
        for (int i : tangerine) {
            if (maxValue < i) {
                maxValue = i;
            }
        }
        int[] arr = new int[maxValue + 1];
        for (int i = 0; i < tangerine.length; i++) {
            arr[tangerine[i]]++;
        }
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            if (k > 0) {
                k -= arr[i];
                answer++;
            }
        }
        return answer;
    }
}