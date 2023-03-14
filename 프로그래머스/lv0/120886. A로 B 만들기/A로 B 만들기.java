    import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        char[] str1 = before.toCharArray();
        char[] str2 = after.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        String be = new String(str1);
        String af = new String(str2);
        if (be.equals(af)){
            answer =1;
        }
        return answer;
    }
}