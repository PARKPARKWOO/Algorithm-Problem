class Solution {
    public int countPalindromicSubsequence(String s) {
        int answer = 0;
        Set<Character> set = new HashSet<>();
        for (char c: s.toCharArray()) {
            set.add(c);
        } 

        for (char c: set) {
            int end = s.lastIndexOf(c);
            int start = s.indexOf(c);
            if (start < end) {
                Set<Character> tmp =new HashSet<>();
                for (int i = start + 1; i < end; i++) {
                    tmp.add(s.charAt(i));
                }
                answer += tmp.size();
            }
        }
        return answer;
    }
}