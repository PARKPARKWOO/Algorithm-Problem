class Solution {
    public boolean isStrictlyPalindromic(int n) {
        boolean result = true;
        for (int i = 2; i < n - 1; i++) {
            if (!check(Integer.toString(n, i))) {
                result = false;
                break;
            }    
        }
        return result;
    }
    
    private boolean check(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}