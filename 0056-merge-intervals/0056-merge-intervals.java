class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] pre = intervals[0];
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (pre[1] >= interval[0]) {
                pre[1] = Math.max(pre[1], interval[1]);
            } else {
                list.add(pre);
                pre = interval;            
            }
        }
        list.add(pre);
        return list.toArray(new int[list.size()][]);
    }
}