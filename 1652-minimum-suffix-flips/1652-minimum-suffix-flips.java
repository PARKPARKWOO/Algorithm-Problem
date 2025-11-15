class Solution {
    public int minFlips(String target) {
        int answer = 0;
        char c = '0';
        for (int i = 0; i < target.length(); i++) {
            if (c != target.charAt(i)) {
                c = target.charAt(i);
                answer++;
            }
        }
        return answer;
    }
}