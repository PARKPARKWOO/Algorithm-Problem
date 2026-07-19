class Solution {
    int MOD = 1_000_000_007;
    int BASE = 256;
    // 256 의 몇승인지
    public int repeatedStringMatch(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int repeatCnt = (aLen + bLen - 1) / aLen;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeatCnt; i++) {
            sb.append(a);
        }
        

        if (rc(sb.toString(), b)) {
            return repeatCnt;
        }

        sb.append(a);
        if (rc(sb.toString(), b)) {
            return repeatCnt + 1;
        }

        return -1;
    }

    boolean rc(
        String text, String pattern
    ) {
        long repeatWindow = 1; 
        long targetHash = 0;
        int bLen = pattern.length();
        long windowHash = 0;
        for (int i = 0; i < bLen; i++) {
            targetHash = (targetHash * BASE + pattern.charAt(i)) % MOD;
            windowHash = (windowHash * BASE + text.charAt(i)) % MOD;
            if (i < bLen - 1) {
                repeatWindow = (repeatWindow * BASE) %MOD;    
            }
        }

        for (int i = 0; i + pattern.length() <= text.length(); i++) {
            if (windowHash == targetHash && isMatch(text, pattern, i)) {
                return true;
            }
            if (i + pattern.length() == text.length()) break;

            char outgoing = text.charAt(i);
            char incomming = text.charAt(i + pattern.length());
            
            windowHash = (windowHash - outgoing * repeatWindow % MOD + MOD) % MOD;
            windowHash = (windowHash * BASE + incomming) % MOD;
        }

        return false;
    }

    boolean isMatch(String text, String pattern, int start) {
        for (int offset = 0; offset < pattern.length(); offset++) {
            if (text.charAt(start + offset) != pattern.charAt(offset)) return false;
        }
        return true;
    }
}