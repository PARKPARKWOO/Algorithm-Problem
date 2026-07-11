class Solution {
    int answer;
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> q = new LinkedList<>();
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (!q.isEmpty() && q.contains(c)) {
                q.poll();
                length--;
            }
            q.add(c);
            length++;
            answer = Math.max(answer, length);
        }
        return answer;
    }
}