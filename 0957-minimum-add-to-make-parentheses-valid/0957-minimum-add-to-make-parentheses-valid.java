import java.util.*;

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> l = new Stack<>();
        int answer = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                l.add(c);
            } else {
                if (l.isEmpty()) {
                    answer++;
                } else {
                    l.pop();
                }
            }
        }     
        return answer + l.size();
    }
}