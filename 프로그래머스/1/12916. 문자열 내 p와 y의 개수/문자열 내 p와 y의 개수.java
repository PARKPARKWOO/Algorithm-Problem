class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String upperCase = s.toUpperCase();
        int p = 0;
        int y = 0;
        for (int i = 0; i <upperCase.length(); i++) {
            if (upperCase.charAt(i) == 'P') p++;
            if (upperCase.charAt(i) == 'Y') y++;
        }
        answer = y == p;
        System.out.println(answer);
        return answer;
    }
}