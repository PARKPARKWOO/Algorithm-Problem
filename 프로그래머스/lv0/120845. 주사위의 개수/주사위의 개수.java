class Solution {
    public int solution(int[] box, int n) {
        int answer = 0;
        int cnt = 1;
        for (int num :
                box) {
            cnt *= (num / n);
        }
        return cnt;
    }
}