class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        int[] pre = new int[2];
        // 첫번째 값으로 정렬
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        pre = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (pre[1] >= next[0]) {
                pre[1] = Math.max(next[1], pre[1]);
            } else {
                list.add(pre);
                pre = next;
            }
        }
        list.add(pre);

        return list.toArray(new int[list.size()][]);
    }
}