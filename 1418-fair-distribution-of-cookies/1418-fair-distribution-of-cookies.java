class Solution {
    int answer = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int[] child = new int[k];
        combination(cookies, k, child, 0);
        return answer;
    }

    private void combination(int[] cookies, int k, int[] child, int idx) {
        if (idx == cookies.length) {
            int r = 0;
            for (int c: child) {
                r = Math.max(c, r);
            }
            answer = Math.min(r, answer);
            return;
        }

        for (int i = 0; i < child.length; i++) {
            child[i] += cookies[idx];
            combination(cookies, k, child, idx + 1);
            child[i] -= cookies[idx];
        }
    }
}