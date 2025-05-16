class Solution {
    boolean[] v;
    int cnt;
    public int findTheWinner(int n, int k) {
        v = new boolean[n];
        cnt = n;
        int answer = 0;
        recursion(0, k, 0);
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                answer = i + 1;
            }
        }
        return answer;
    }
    private void recursion(int idx, int k, int depth) {
        if (cnt == 1) return;
        if (!v[idx]) {
            depth++;
            if (depth == k) {
                v[idx] = true;
                cnt--;
                depth = 0;
            }
        }
        int nextIdx = (idx + 1) % v.length;
        recursion(nextIdx, k, depth);
    }
}