class Solution {
    String[] str = new String[]{"M", "CM","D", "CD" ,"C", "XC","L", "XL","X", "IX","V", "IV","I"};
    int[] n = new int[]{1000, 900,500,400, 100,90, 50, 40,10,9, 5, 4,1};
    public String intToRoman(int num) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num >= n[idx]) {
                sb.append(str[idx]);
                num -= n[idx];
            } else {
                idx++;
            }
        }
        return sb.toString();
    }
}