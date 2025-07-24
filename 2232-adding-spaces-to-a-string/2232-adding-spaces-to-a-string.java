class Solution {
    private int n;
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, spaces[0]));
        for (int i = 1; i < spaces.length; i++) {
            sb.append(" ");
            sb.append(s.substring(spaces[i - 1], spaces[i]));
        }
        sb.append(" ");
        sb.append(s.substring(spaces[spaces.length-1]));
        return sb.toString();
    }
}