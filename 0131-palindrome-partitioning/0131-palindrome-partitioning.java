class Solution {
    private String[] dp;
    private List<List<String>> answer;
    public List<List<String>> partition(String s) {
        answer = new ArrayList<>();
        combination(s, 0, new ArrayList<>());
        return answer;
    }
    private void combination(String n, int k, List<String> list) {
        if (k == n.length()) {
            answer.add(new ArrayList<>(list));
            return;
        }
        
        for (int end = k + 1; end <= n.length(); end++) {
            String s = n.substring(k, end); 
            if (isPalindrome(s)) {
                list.add(s);
                combination(n, end, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}