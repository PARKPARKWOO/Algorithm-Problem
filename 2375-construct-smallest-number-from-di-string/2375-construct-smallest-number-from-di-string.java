class Solution {
    private boolean[] v = new boolean[10];
    private String answer;
    public String smallestNumber(String pattern) {
        for (int i = 1; i <= 9; i++) {
            v[i] = true;
            boolean isAnswer = recursive(pattern, 0, String.valueOf(i));
            v[i] = false;
            if (isAnswer) break;
        }
        return answer;
    }
    
    private boolean recursive(String pattern, int idx, String cur) {
        if (pattern.length() + 1 == cur.length()) {
            answer = cur;
            return true;
        }
        
        int num = cur.charAt(idx) - '0';
        boolean isUp = pattern.charAt(idx) == 'I';
        
        if (isUp) {
            for (int i = num + 1; i <= 9; i++) {
                if (!v[i]) {
                    v[i] = true;
                    if (recursive(pattern, idx + 1, cur + i)) return true;
                    v[i] = false;
                }
            }
        } else {
            for (int i = 1; i < num; i++) {
                if (!v[i]) {
                    v[i] = true;
                    if (recursive(pattern, idx + 1, cur + i)) return true;
                    v[i] = false;
                }
            }
        }
        return false;
    }
}