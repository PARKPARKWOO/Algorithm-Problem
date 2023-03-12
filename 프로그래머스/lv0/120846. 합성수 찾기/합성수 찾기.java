import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (arr[i] == true){
                int j = 2;
                while (i * j <= n){
                    arr[i * j] = false;
                    j++;
                }
            }
        }
        for (boolean tf:
             arr) {
            if (tf == true){
                answer++;
            }
        }
        return n - answer + 1;
    }
}