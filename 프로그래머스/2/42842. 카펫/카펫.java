class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int maxNum = 0;
        int minNum = 0;
        for (int i = 3; i <= Math.sqrt(total); i++) {
            if (total % i == 0) {
                int width = total / i;
                if ((i - 2) * (width - 2) == yellow) {
                    minNum = Math.min(i, width);
                    maxNum = Math.max(i, width);
                }
            }
        }
        int[] answer = new int[]{maxNum, minNum};
        return answer;
    }
}