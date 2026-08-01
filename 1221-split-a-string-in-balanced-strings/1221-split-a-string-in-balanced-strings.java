class Solution {
    public int balancedStringSplit(String s) {
        int answer = 0;
        int cnt = 0;
        for (int i =0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'R') {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt == 0) {
                answer++;
            }
        }
        return answer;
    }
}