class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merge = new ArrayList<>();
        int[] pre = new int[2];
        pre = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] inter = intervals[i];
            // pre 의 값의 범위 안에 [0] 의 값이 포함된다면 merge 를 진행한다.
            if (pre[1] >= inter[0]) {
                pre[1] = Math.max(pre[1], inter[1]);
            } else {
                merge.add(pre);
                pre = inter;
            }
        }
        merge.add(pre);
        return merge.toArray(new int[merge.size()][]);
    }
}