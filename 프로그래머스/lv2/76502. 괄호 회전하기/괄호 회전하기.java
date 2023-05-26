import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (check(s)) {
                answer++;
            }
            String temp = String.valueOf(s.charAt(0));
            s = s.substring(1, s.length()) + temp;
        }
        return answer;
    }

    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.size() == 0) {
                stack.add(s.charAt(i));
            } else if (s.charAt(i) == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (s.charAt(i) == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.add(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}