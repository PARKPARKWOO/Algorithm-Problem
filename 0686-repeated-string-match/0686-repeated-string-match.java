class Solution {
    int aLen;
    int bLen;
    public int repeatedStringMatch(String a, String b) {
        aLen = a.length();
        bLen = b.length();
        
        int repeatCnt = (aLen + bLen - 1) / aLen;

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < repeatCnt; i++) {
            sb.append(a);
        }

        if (contains(sb.toString(), b)) return repeatCnt;
        
        sb.append(a);
        if (contains(sb.toString(), b)) return repeatCnt + 1;
        
        return -1;
    }
    boolean contains(String text, String pattern) {
        int windowHash = 0;
        int patternHash = 0;
        
        for (int i = 0; i < pattern.length(); i++) {
            windowHash += text.charAt(i);
            patternHash += pattern.charAt(i);    
        }

        for (int i = 0; i < text.length() - pattern.length(); i++) {
            if (windowHash == patternHash && isMatch(text, pattern, i)) return true;
            windowHash -= text.charAt(i);
            windowHash += text.charAt(i + pattern.length());
        }
        if (windowHash == patternHash && isMatch(text, pattern, text.length() - pattern.length())) return true;
        return false;
    }

    boolean isMatch(String text, String pattern, int start) {
        for (int i = 0; i < pattern.length(); i++) {
            if (text.charAt(start + i) != pattern.charAt(i)) return false;
        }

        return true;
    }
}