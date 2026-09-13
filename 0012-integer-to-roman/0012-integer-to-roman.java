class Solution {
    int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,1};
    String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV","I"};
    public String intToRoman(int num) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        while (num > 0) {
            if (num >= n[idx]) {
                num -= n[idx];
                answer.append(str[idx]); 
            } else {
                idx++;
            }
        }

        return answer.toString();
    }
}