class Solution {
    int target = 0;
    public String removeOccurrences(String s, String part) {
        for (char c : part.toCharArray()) {
            target += c - 'a';
        }
        int start = 0;
        int end = 1;
        int sum = 0;
        int size = 0;
        while (true) {
            String tmp = s.replaceFirst(part, "");
            if (tmp.length() == s.length()) {
                s = tmp;
                break;
            }
            s = tmp;
        }
        return s;
    }
}