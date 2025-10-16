class Solution {
    private List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        combination(k, new ArrayList<>(), 0, n, 1);
        return answer;
    }

    private void combination(int k, List<Integer> list, int sum, int n, int now) {
        if (k == list.size()) {
            if (sum == n) {
                List<Integer> r = new ArrayList<>();
                r.addAll(list);
                answer.add(r);
            }
            return;
        }
        if (now > 9) return;
        if (n <= sum) return;
        int a = now + 1;
        combination(k, list, sum, n, a);
        list.add(now);
        combination(k, list, sum + now, n, a);
        list.remove(list.size() - 1);
    }
}