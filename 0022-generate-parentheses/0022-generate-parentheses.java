class Solution {
    private List<String> answer;
    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        recursive(n, 1,"(");
        return answer;
    }
    // ( 의 개수를 뜻함
    private void recursive(int n, int depth,String str) {
        if (n * 2 == str.length()) {
            if (depth == 0) {
                answer.add(str);       
            }
            return;
        }
        str += "(";
        recursive(n, depth + 1, str);
        str = str.substring(0, str.length() - 1);

        if (depth > 0) {
            str += ")";
            recursive(n, depth - 1, str);
            str = str.substring(0, str.length() - 1);
        }
    }
}