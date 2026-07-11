class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] pre = intervals[0]; 
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int[] inter = intervals[i];
            if (pre[1] >= inter[0]) {
                pre[1] = Math.max(pre[1], inter[1]);
            } else {
                list.add(pre);
                pre = inter;
            }
        }

        list.add(pre);
        return list.toArray(new int[list.size()][]);
    }
}