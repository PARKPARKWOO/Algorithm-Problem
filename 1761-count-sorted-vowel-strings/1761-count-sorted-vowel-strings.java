class Solution {
    private char[] elements = new char[]{'a', 'e', 'i', 'o', 'u'};
    private Set<String> set = new HashSet<>();
    public int countVowelStrings(int n) {
        recursive(n, "", 0);
        return set.size();
    }

    private void recursive(int n, String str, int idx) {
        if (str.length() == n) {
            set.add(str);
            return;
        }

        for (int i = idx; i < elements.length; i++) {
            recursive(n, str + elements[i], i);
        }
    }
}