class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int n = diffs.length;
        int maxDiff = 0;
        for (int d : diffs) {
            if (d > maxDiff) maxDiff = d;
        }

        int low = 1, high = maxDiff, ans = maxDiff;
        while (low <= high) {
            int mid = (low + high) >>> 1;  
            if (canFinish(diffs, times, limit, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    /** 주어진 level로 모든 퍼즐을 푸는 데 걸리는 시간이 limit 이내인지 여부 */
    private boolean canFinish(int[] diffs, int[] times, long limit, int level) {
        long totalTime = 0;
        int prevTime = 0;
        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i], cur = times[i];
            int gap = diff - level;
            if (gap > 0) {
                // 틀린 횟수 × (현재 시간 + 이전 시간) + 마지막 풀이 시간
                totalTime += (long) gap * (cur + prevTime) + cur;
            } else {
                // 틀리지 않고 바로 정답
                totalTime += cur;
            }
            if (totalTime > limit) {
                return false;  // 초과 시 바로 false
            }
            prevTime = cur;
        }
        return totalTime <= limit;
    }
}
