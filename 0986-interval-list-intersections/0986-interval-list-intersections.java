class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> graph = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (firstList.length > i && secondList.length > j) {
            int sf = firstList[i][0];
            int ef = firstList[i][1];
            int ss = secondList[j][0];
            int es = secondList[j][1];
            if ((sf <= ss && ef >= ss) || (sf >= ss && sf <= es)) {
                graph.add(new int[]{Math.max(sf, ss), Math.min(ef, es)});
            }
            
            if (ef < es) {
                i++;
            } else if (ef > es) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        int[][] answer = new int[graph.size()][2];
        for (int x = 0; x < graph.size(); x++) {
            int[] arr = graph.get(x);
            answer[x] = arr;
        }
        return answer;
    }
}