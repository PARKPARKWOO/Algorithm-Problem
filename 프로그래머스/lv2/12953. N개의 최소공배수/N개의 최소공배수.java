class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i : arr) {
            answer = (i * answer) / gcd(i, answer);
        }
        return answer;
    }
    public int gcd(int a, int b) {
        int temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}