class Solution {
    public int solution(int n) {
        int answer = 0;
        int bn = Integer.toBinaryString(n).length() - Integer.toBinaryString(n).replace("1", "").length();
        for (int i = n+1; i < 1000001; i++) {
            int bi = Integer.toBinaryString(i).length() - Integer.toBinaryString(i).replace("1", "").length();
            if (bi == bn) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}