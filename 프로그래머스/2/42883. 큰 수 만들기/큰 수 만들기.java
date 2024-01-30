
class Solution {
    private long maxNum;
    private char numStartWith;
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int start = 0;
        int len = number.length() - k;
        for (int i = 0; i < len; i++) {
            char max = '0';
            for (int j = start; j <= i + k; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    start = j + 1;
                }
            }
            answer.append(String.valueOf(max));
        }
        
        return answer.toString();
    }
}