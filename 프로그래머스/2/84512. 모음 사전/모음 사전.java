class Solution {
    private String[] words = {"A", "E", "I", "O", "U"};
    private int result;
    public int solution(String word) {
        int answer = 0;
        recursive("", word, 0);
        return result;
    }
    private int recursive(String now, String word, int depth) {
        if (now.equals(word)) {
            result = depth;
            return depth;
        }
        if (now.length() == 5) {
            return depth;
        }
    
        for (int i = 0; i < words.length; i++) {
            depth = recursive(now + words[i], word, depth + 1);
        }
        return depth;
    }
}