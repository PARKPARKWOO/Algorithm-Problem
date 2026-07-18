class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<String> set = new HashSet<>();
        int start = 0;
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (!set.contains(str)) {
                set.add(str);
                maxLen = Math.max(maxLen, i - start + 1);
            } else {
                while (start < i) {
                    String ss = String.valueOf(s.charAt(start++));
                    set.remove(ss);
                    
                    if (str.equals(ss)) {
                        set.add(ss);
                        break;
                    }
                }
            }
        }
        return maxLen;
    }
}