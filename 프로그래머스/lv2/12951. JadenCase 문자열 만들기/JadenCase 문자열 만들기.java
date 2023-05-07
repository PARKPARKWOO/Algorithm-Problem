class Solution {
    public String solution(String s) {
        String answer = "";
        String[] list = s.split(" ");
        for (String s1 : list) {
            if (s1.length() == 0) {
                answer += " ";
            }else {
                answer += s1.substring(0, 1).toUpperCase() + s1.substring(1).toLowerCase() + " ";
            }
        }
        if (s.substring(s.length() - 1, s.length()).equals(" ")) {
            return answer;
        }
        return answer.trim();
    }
}