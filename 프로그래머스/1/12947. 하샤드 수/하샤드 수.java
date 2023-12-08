class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String str = String.valueOf(x);
        int length = str.length();

        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            num += str.charAt(i) - '0';
        }
        return x % num == 0;
    }
}