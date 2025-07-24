class Solution {
    private int n;
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        for (int sn: spaces) {
            int dn = sn + n;
            n++;
            sb.insert(dn, " ");
        }
        return sb.toString();
    }
}