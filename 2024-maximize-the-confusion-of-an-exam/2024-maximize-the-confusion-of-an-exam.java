class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int[] mem = new int[26];
        int answer = 0;
        int max = 0;
        int left = 0;
        for (int i = 0; i < answerKey.length(); i++) {
            char c = answerKey.charAt(i);
            max = Math.max(max, ++mem[c - 'A']);
            while ((i - left + 1) - max > k) {
                mem[answerKey.charAt(left) - 'A']--;
                left++;
            }
            answer =Math.max(answer, i - left + 1);
        }
        return answer;
    }
}