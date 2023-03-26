class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            sb.append((i+ "").repeat(food[i]/ 2));
        }
        String sb_re = new String(sb.reverse());
        sb.reverse();
        sb.append("0");
        sb.append(sb_re);
        return sb.toString();
    }
}