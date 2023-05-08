class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while (s.length() > 1) {
            int temp = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') answer[1]++;
                else temp++;
            }
            s = Integer.toBinaryString(temp);
            answer[0]++;
        }

        return answer;
    }
}