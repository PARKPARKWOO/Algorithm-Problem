class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[11];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= 10; i++) {
            arr[i] = i * arr[i-1];
        }
        for (int i = 1; i <= 10; i++) {
            if (n < arr[i]){
                answer = i - 1;
                break;
            } else if (n == arr[i]){
                answer = i;
            }
        }
        return answer;
    }
}