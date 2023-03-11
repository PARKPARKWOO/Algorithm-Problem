class Solution {
    public String solution(int age) {
        String answer = "";
        String age_str = age + "";
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < age_str.length(); i++) {
            answer += alpha.charAt(age_str.charAt(i) - '0');
        }
        return answer;
    }
}