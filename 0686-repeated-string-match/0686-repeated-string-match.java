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

        if (sb.indexOf(b) != -1) return repeatCnt;
        
        sb.append(a);
        if (sb.indexOf(b) != -1) return repeatCnt + 1;
        
        return -1;
    }
}