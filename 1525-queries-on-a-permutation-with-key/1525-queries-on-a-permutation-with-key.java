class Solution {
    private int[] p;
    private int[] answer;
    public int[] processQueries(int[] queries, int m) {
        p = new int[m];
        answer = new int[queries.length];
        for (int i = 1; i <= m; i++) {
            p[i - 1] = i;
        }
        for (int i = 0; i < queries.length; i++) {
            query(queries[i], i);
        }
        return answer;
    }

    private void query(int value, int idx) {
        for (int i = 0; i < p.length; i++) {
            if (p[i] == value) {
                sort(i);
                answer[idx] = i;
                return;
            }
        }
    }

    private void sort(int target) {
        int temp = p[target];
        for (int i = target; i > 0; i--) {
            p[i] = p[i - 1];
        }
        p[0] =temp;
    }
}