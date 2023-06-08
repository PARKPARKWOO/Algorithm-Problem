class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        int idx = 0;
        int ileft = (int) left;
        int iright = (int) right;
        for (long i = left; i < right + 1; i++) {
            int a = (int) (i / n);
            int b = (int) (i % n);
            if (a < b) {
                a = b;
            }
            answer[idx++] = a+1;
        }
        return answer;
    }
}