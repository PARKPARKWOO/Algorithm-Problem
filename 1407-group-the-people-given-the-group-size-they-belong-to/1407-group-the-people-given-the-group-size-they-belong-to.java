class Solution {
    private int[] cnt;
    private List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int n : groupSizes) {
            max = Math.max(max, n);
            List<Integer> list = map.get(n);
            if (list == null) {
                map.put(n, new ArrayList<>());
            }
        }
        cnt = new int[max + 1];
        for (int i = 0; i < groupSizes.length; i++) {
            int n = groupSizes[i];
            List<Integer> list = map.get(n);   
            if (cnt[n] + 1 < n) {
                cnt[n]++;
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(i);
                // map.put(n, list);
            } else if (cnt[n] + 1 == n){
                list.add(i);
                List<Integer> l = new ArrayList<>();
                l.addAll(list);
                answer.add(l);
                cnt[n] = 0;
                list.clear();
            }
        }
        return answer;
    }
}