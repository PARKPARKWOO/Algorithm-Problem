class Solution {
    List<String> answer = new ArrayList<>();
    int cnt = 0;
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        if (words.length == 0) return answer;
        answer.add(words[0]);
        
        for (int i = 1; i < groups.length; i++) {
            if (groups[i] != groups[i - 1]) {
                answer.add(words[i]);
            }
        }
     
        return answer;
    }
}