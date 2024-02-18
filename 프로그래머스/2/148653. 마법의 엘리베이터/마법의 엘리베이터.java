class Solution {
    public int solution(int storey) {
        int answer = 0;
        String str = storey + "";
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > 5) {
                answer += 10 - arr[i];
                if(i==0) answer++;
                else arr[i-1]++;
            } else if (arr[i] == 5 && i > 0 && arr[i - 1] >= 5) {
                answer += 5;
                arr[i - 1]++;
            } else {
                answer += arr[i];
            }
        }
        return answer;
    }
}