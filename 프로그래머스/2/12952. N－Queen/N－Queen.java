class Solution {
    private int result;
    private int[] map; // index = 행 value = 열
    public int solution(int n) {
        int answer = 0;
        result = 0;
        map = new int[n];
        backTracking(0, n);
        return result;
    }
    
    private void backTracking(int depth, int n) {
        if (depth == n) {
            result++;
            return;
        }
        for (int i =0; i < n; i++) {
            map[depth] = i;
            if(valid(depth)) {
                backTracking(depth + 1, n);
            }
        }
    }
    
    private boolean valid(int depth) {
        for (int i =0; i < depth; i++) {
            if (map[i] == map[depth]) return false;
            if (Math.abs(map[i] - map[depth]) == Math.abs(i - depth)) return false;
        }
        return true;
    }
}