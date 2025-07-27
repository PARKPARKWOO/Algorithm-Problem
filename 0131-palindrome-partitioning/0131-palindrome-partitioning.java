class Solution {
    private boolean[][] dp;
    private List<List<String>> answer;
    public List<List<String>> partition(String s) {
        answer = new ArrayList<>();
        dp = new boolean[s.length() +1][s.length() + 1];
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
            if (dp[k][end]) {
                list.add(s);
                combination(n, end, list);
                list.remove(list.size() - 1);
            } else {
                if (isPalindrome(s)) {
                    list.add(s);
                    combination(n, end, list);
                    list.remove(list.size() - 1);
                    dp[k][end] = true;
                }   
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