class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int[] merge = new int[2];
        int start = newInterval[0];
        int end = newInterval[1];
        
        int ns = newInterval[0];
        int ne = newInterval[1];
        
        int idx = 0;
        
        while (idx < intervals.length && ns > intervals[idx][1]) {
            list.add(intervals[idx++]);
        }
        
        while (idx < intervals.length && intervals[idx][0] <= end) {
            start = Math.min(start, intervals[idx][0]);
            end = Math.max(end, intervals[idx][1]);
            idx++;
        }
        merge[0] = start;
        merge[1] = end;
        list.add(merge);
        while (idx < intervals.length) {
            list.add(intervals[idx++]);
        }
        return list.toArray(new int[list.size()][]);
    }
}