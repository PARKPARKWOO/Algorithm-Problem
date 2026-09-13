class Solution {
    public String shortestPalindrome(String s) {
        // 문자열 s 의 prefix 에 부족한 부ㅜㅂㄴ을 채워 넣어야한다.
        // s 의 앞 뒤 중 어디까지가 일치하는가?
        int left = 0;
        
        for (int right = s.length() - 1; right >= 0; right--) {
            if (s.charAt(left) == s.charAt(right)) left++;
        }

        if (s.length() == left) return s;

        String suffix = s.substring(left, s.length());
        
        return new StringBuffer(suffix).reverse() + shortestPalindrome(s.substring(0, left)) + suffix;
    }
}