class Solution {
    List<String> result = new ArrayList<>();
    String[] arr = {"a", "b", "c"};
    Set<String> set = new HashSet<>();
    public String getHappyString(int n, int k) {
        recursive(new StringBuilder(), n);
        int size = result.size();
        if (size < k) {
            return "";
        }
        return result.get(k - 1);
    }

    private void recursive(StringBuilder str, int n) {
        if (str.length() == n) {
            result.add(str.toString());
            return;
        }

        for (String s: arr) {
            if (str.length() == 0 || s.charAt(0) != str.charAt(str.length() - 1)) {
                str.append(s);
                recursive(str, n);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }
}