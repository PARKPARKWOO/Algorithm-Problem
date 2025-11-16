class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                answer++;
            } else if(answer > 0){                
                answer--;
            }
        }
        return (answer + 1) / 2;
    }
}