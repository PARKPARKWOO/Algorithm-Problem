class Solution {
    int answer = Integer.MAX_VALUE;
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int minW = 2500;
        int minL = 2500; 
        
        for (int i = 0; i < n; i++) {
            minL = Math.min(minL, landStartTime[i] + landDuration[i]);
        }

        for (int i = 0; i < m; i++) {
            minW = Math.min(minW, waterStartTime[i] + waterDuration[i]);
            answer = Math.min(answer, Math.max(minL, waterStartTime[i]) + waterDuration[i]);
        }

        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, Math.max(minW, landStartTime[i]) + landDuration[i]);
        }
        return answer;
    }
}