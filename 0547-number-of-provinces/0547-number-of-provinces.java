class Solution {
    private boolean[] v;
    private int answer;
    public int findCircleNum(int[][] isConnected) {
        v = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            bfs(isConnected, i);
        }
        return answer;
    }
    
    private void bfs(int[][] isConnected, int start) {
        if (v[start]) {
            return;
        }
        answer++;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int poll = q.poll();
            int[] arr = isConnected[poll];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1 && !v[i]) {
                    v[i] = true;
                    q.add(i);
                }
            }
        }
    }
}