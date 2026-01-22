class Solution {
    private List<String> answer = new ArrayList<>();
    public List<String> validStrings(int n) {
        recursive("", n);
        return answer;
    }

    private void recursive(String str, int n) {
        if (str.length() == n) {
            answer.add(str);
            return;
        }
        if (str.length() != 0 && str.charAt(str.length() - 1) == '0') {
            recursive(str + 1, n);
        } else {
            recursive(str + 1, n);
            recursive(str + 0, n);
        }
    }
}