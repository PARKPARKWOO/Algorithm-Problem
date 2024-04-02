class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int max = t * m;
        for (int i =0; i <= max; i++) {
            sb.append(Integer.toString(i, n));
        }
        for (int i = p - 1; i < max; i+=m) {
            answer.append(sb.toString().charAt(i));
        }
        return answer.toString().toUpperCase();
    }
}