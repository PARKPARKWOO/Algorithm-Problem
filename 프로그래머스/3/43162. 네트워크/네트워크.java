class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] c = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!c[i]) {
                dfs(computers, i, c);
                answer++;
            }
        }
        return answer;
    }
    private void dfs(int[][] computers, int i, boolean[] c) {
        c[i] = true;
        for (int j = 0; j < computers.length; j++) {
            if (computers[i][j] == 1 && !c[j]) {
                dfs(computers, j, c);
            }
        }
    }
}