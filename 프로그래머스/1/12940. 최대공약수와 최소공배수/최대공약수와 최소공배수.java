class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int gdc = gdc(n, m);
        int abc = (n * m) / gdc;
        answer[0] = gdc;
        answer[1] = abc;
        return answer;
    }

    private int gdc(int a, int b) {
        int big = 0;
        int small = 0;
        if (a > b) {
            big = a;
            small = b;
        } else {
            big = b;
            small = a;
        }

        int result = big % small;
        if (result == 0) return small;
        return gdc(small, result);
    }
}
