class Solution {
    int result;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] v = new boolean[dungeons.length];
        result = 0;
        for (int i =0; i < dungeons.length; i++) {
            if (dungeons[i][0] <= k) {
                v[i] = true;
                recursive(k - dungeons[i][1], v, 1, dungeons);
                v[i] = false;
            }
        }
        return result;
    }
    // now = 현재 피로도
    // depth = 현재 방문한 던전 수
    private void recursive(int now, boolean[] v, int depth, int[][] dungeons) {
        boolean vi = false;
        for (int i = 0; i < dungeons.length; i++) {
            if (!v[i] && now >= dungeons[i][0]) {
                v[i] = true;
                recursive(now - dungeons[i][1], v, depth + 1, dungeons);
                v[i] = false;
                vi = true;
            }
        }
        if (!vi) {
            result = Math.max(result, depth);
        }
    }
}