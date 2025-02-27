import java.util.*;

class Solution {
    Set<String> set = new HashSet<>();
    public List<String> validStrings(int n) {
        re(n, "0");
        re(n, "1");
        return new ArrayList<>(set);
    }
    private void re(int n, String now) {
        if (now.length() == n) {
            set.add(now);
            return;
        }

        if (valid(now)) return;
        if (now.charAt(now.length() - 1) == '0') {
            re(n, now + "1");    
        } else {
            re(n, now + "0");
            re(n, now + "1");
        }
        
    }

    private boolean valid(String s) {
        return s.startsWith("00");
    } 
}